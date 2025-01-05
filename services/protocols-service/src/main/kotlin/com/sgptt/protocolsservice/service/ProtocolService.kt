package com.sgptt.protocolsservice.service

import com.sgptt.protocolsservice.extension.toDomain
import com.sgptt.protocolsservice.model.ActivityName
import com.sgptt.protocolsservice.model.ProtocolPage
import com.sgptt.protocolsservice.model.State
import com.sgptt.protocolsservice.model.dto.EmptyProtocol
import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.exception.DifferentCareerException
import com.sgptt.protocolsservice.model.exception.EntityNotFoundException
import com.sgptt.protocolsservice.model.exception.ProfessorNotFoundException
import com.sgptt.protocolsservice.model.exception.ProtocolNotFoundException
import com.sgptt.protocolsservice.model.exception.StudentNotFoundException
import com.sgptt.protocolsservice.model.exception.WrongUploadDateException
import com.sgptt.protocolsservice.repository.ActivityRepository
import com.sgptt.protocolsservice.repository.ProfessorRepository
import com.sgptt.protocolsservice.repository.ProtocolRepository
import com.sgptt.protocolsservice.repository.ProtocolSearchRepository
import com.sgptt.protocolsservice.repository.StudentRepository
import com.sgptt.protocolsservice.repository.entity.Professor
import com.sgptt.protocolsservice.repository.entity.Protocol
import com.sgptt.protocolsservice.repository.entity.ProtocolDocument
import com.sgptt.protocolsservice.repository.entity.Student
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.Date
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ProtocolService(
	private val protocolRepository: ProtocolRepository,
	private val studentRepository: StudentRepository,
	private val professorRepository: ProfessorRepository,
	private val activityRepository: ActivityRepository,
	private val documentRepository: ProtocolSearchRepository
) {
	
	fun getPageOfProtocols(pageable: Pageable): ProtocolPage {
		val page = protocolRepository.findAll(pageable)
		return ProtocolPage(
			totalPages = page.totalPages,
			totalItems = page.totalElements,
			currentPage = page.number,
			protocols = page.content.map { it.toDomain() }
		)
	}
	
	fun findById(id: Long): ProtocolDTO =
		protocolRepository.findById(id).orElse(EmptyProtocol).toDomain()
	
	fun findAllByStudentId(id: Long): List<ProtocolDTO> =
		protocolRepository.findAllByStudentId(id).map { it.toDomain() }
	
	fun findAllByProfessorId(id: Long): List<ProtocolDTO> =
		protocolRepository.findAllByProfessorId(id).map { it.toDomain() }
	
	fun findBySynodalId(id: Long): List<ProtocolDTO> = protocolRepository.findBySynodalId(id).map { it.toDomain() }
	
	val allProtocolsMissingSynodals: List<ProtocolDTO>
		get() = protocolRepository.findAllBySinodalsCountIsLessThan3().map { it.toDomain() }
	
	val allProtocolsSinodalsAreFull: List<ProtocolDTO>
		get() = protocolRepository.findAllBySinodalAreFull().map { it.toDomain() }
	
	@Throws(EntityNotFoundException::class)
	fun findAllSuggestionByProfessorAcademy(professorId: Long): List<ProtocolDTO> {
		val professor = professorRepository.findById(professorId).orElseThrow {
			ProfessorNotFoundException("Professor with number $professorId not found")
		}
		return protocolRepository.findAllSuggestionByProfessorAcademy(professor.academy.name).map { it.toDomain() }
	}
	
	@Throws(EntityNotFoundException::class, WrongUploadDateException::class, DifferentCareerException::class)
	fun registryProtocol(
		file: MultipartFile,
		studentId: Long,
		protocolTitle: String,
		protocolKeywords: List<String>,
		protocolAbstract: String,
		workMates: List<String>,
		directors: List<String>,
	): ProtocolDTO {
		
		val whoIsUploadingProtocol = studentRepository.findById(studentId).orElseThrow {
			StudentNotFoundException("Student with enrollment $studentId not found")
		}
		
		val activityName = if (whoIsUploadingProtocol.isIrregular)
			ActivityName.UPLOAD_PROTOCOLS_IRREGULAR_STUDENTS
		else
			ActivityName.UPLOAD_PROTOCOLS_REGULAR_STUDENTS
		
		val activity = activityRepository.findByActivity(activityName)
		
		val today = Date()
		
		if (today.before(activity.openDate) || today.after(activity.closeDate)) {
			val message = buildString {
				append("This service is temporally unavailable")
				append('\n')
				append(" you can upload your protocol between the following dates ")
				append(activity.openDate)
				append(" and ")
				append(activity.closeDate)
			}
			throw WrongUploadDateException(message)
		}
		
		val allStudents: Set<Student> = buildSet {
			add(whoIsUploadingProtocol)
			workMates.forEach { studentId ->
				if (!studentRepository.existsStudentByStudentNumber(studentId))
					throw StudentNotFoundException("Student with enrollment $studentId not found")
				val mate = studentRepository.findByStudentNumber(studentId)
				if (whoIsUploadingProtocol.career != mate.career)
					throwDifferentSameCareerException(whoIsUploadingProtocol, mate)
				add(mate)
			}
		}
		
		val allDirectors: Set<Professor> = getAllDirectorsFromEmployerNumbers(directors)!!
		
		val protocol = Protocol(
			title = protocolTitle,
			keywords = protocolKeywords.joinToString(separator = ","),
			protocolAbstract = protocolAbstract,
			fileData = file.bytes,
			state = State.PENDING,
			createdAt = Timestamp.valueOf(LocalDateTime.now()),
			academies = emptySet(),
			students = allStudents.toMutableSet(),
			directors = allDirectors.toMutableSet(),
			sinodals = emptySet()
		)
		
		val newProtocol = protocolRepository.save(protocol)
		
		allStudents.forEach {
			it.protocols.add(newProtocol)
			studentRepository.save(it)
		}
		
		val protocolDocument = ProtocolDocument(
			title = newProtocol.title,
			keywords = newProtocol.keywords,
			protocolAbstract = newProtocol.protocolAbstract,
		)
		
		documentRepository.save(protocolDocument)
		
		return newProtocol.toDomain()
	}
	
	@Throws(EntityNotFoundException::class, DifferentCareerException::class)
	fun updateProtocol(
		protocolId: Long,
		file: MultipartFile?,
		title: String?,
		keywords: List<String>?,
		abstract: String?,
		workMates: List<String>?,
		directors: List<String>?,
	): ProtocolDTO {
		val protocolToUpdate = protocolRepository.findById(protocolId).orElseThrow {
			ProtocolNotFoundException("Protocol with id $protocolId wasn't found in the database")
		}
		
		val allStudents: Set<Student>? = workMates?.let {
			lateinit var firstStudent: Student
			buildSet {
				it.forEachIndexed { index, studentId ->
					if (!studentRepository.existsStudentByStudentNumber(studentId))
						throw StudentNotFoundException("Student with enrollment $studentId not found")
					if (index == 0) {
						firstStudent = studentRepository.findByStudentNumber(studentId)
						add(firstStudent)
					} else {
						val student = studentRepository.findByStudentNumber(studentId)
						if (firstStudent.career != student.career)
							throwDifferentSameCareerException(firstStudent, student)
						add(student)
					}
				}
			}
		}
		
		val allDirectors: Set<Professor>? = getAllDirectorsFromEmployerNumbers(directors)
		
		protocolToUpdate.apply {
			title?.let { this.title = it }
			file?.let { this.fileData = it.bytes }
			keywords?.let { this.keywords = it.joinToString(separator = ",") }
			abstract?.let { this.protocolAbstract = it }
			allStudents?.let { this.students.clear(); this.students.addAll(it) }
			allDirectors?.let { this.directors.clear(); this.directors.addAll(it) }
		}
		
		return protocolRepository.save(protocolToUpdate).toDomain()
	}
	
	private fun throwDifferentSameCareerException(s1: Student, s2: Student): Nothing {
		val message = buildMap {
			with(s1) {
				put("$name $paternalSurname $maternalSurname", career)
			}
			with(s2) {
				put("$name $paternalSurname $maternalSurname", career)
			}
		}
		throw DifferentCareerException("$message")
	}
	
	
	@OptIn(ExperimentalContracts::class)
	private fun getAllDirectorsFromEmployerNumbers(numbers: List<String>?): Set<Professor>? {
		contract {
			returnsNotNull() implies (numbers != null)
			returns(null) implies (numbers == null)
		}
		
		return numbers?.let { directors ->
			buildSet {
				directors.forEach { employerNumber ->
					if (!professorRepository.existsProfessorByProfessorNumber(employerNumber))
						throw ProfessorNotFoundException("Professor with number $employerNumber not found")
					add(professorRepository.findByProfessorNumber(employerNumber))
				}
			}
		}
	}
}