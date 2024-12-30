package com.sgptt.protocolsservice.service

import com.sgptt.protocolsservice.extension.toDomain
import com.sgptt.protocolsservice.model.ActivityName
import com.sgptt.protocolsservice.model.ProtocolPage
import com.sgptt.protocolsservice.model.State
import com.sgptt.protocolsservice.model.dto.EmptyProtocol
import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.exception.EntityNotFoundException
import com.sgptt.protocolsservice.model.exception.ProfessorNotFoundException
import com.sgptt.protocolsservice.model.exception.StudentNotFoundException
import com.sgptt.protocolsservice.model.exception.WrongUploadDateException
import com.sgptt.protocolsservice.repository.ActivityRepository
import com.sgptt.protocolsservice.repository.ProfessorRepository
import com.sgptt.protocolsservice.repository.ProtocolRepository
import com.sgptt.protocolsservice.repository.StudentRepository
import com.sgptt.protocolsservice.repository.entity.Professor
import com.sgptt.protocolsservice.repository.entity.Protocol
import com.sgptt.protocolsservice.repository.entity.Student
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*

@Service
class ProtocolService(
	private val protocolRepository: ProtocolRepository,
	private val studentRepository: StudentRepository,
	private val professorRepository: ProfessorRepository,
	private val activityRepository: ActivityRepository,
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
		protocolRepository.findById(id).orElse(EmptyProtocol).toDomain(withFile = true)
	
	@Throws(EntityNotFoundException::class, WrongUploadDateException::class)
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
				append("you can upload your protocol between the following dates")
				append(activity.openDate)
				append(" and ")
				append(activity.closeDate)
			}
			throw WrongUploadDateException(message)
		}
		
		val allStudents: Set<Student> = buildSet {
			workMates.forEach { studentId ->
				add(whoIsUploadingProtocol)
				if (!studentRepository.existsStudentByStudentNumber(studentId))
					throw StudentNotFoundException("Student with enrollment $studentId not found")
				add(studentRepository.findByStudentNumber(studentId))
			}
		}
		
		val allDirectors: Set<Professor> = buildSet {
			directors.forEach { employerNumber ->
				if (!professorRepository.existsProfessorByProfessorNumber(employerNumber))
					throw ProfessorNotFoundException("Professor with number $employerNumber not found")
				add(professorRepository.findByProfessorNumber(employerNumber))
			}
		}
		
		val protocol = Protocol(
			title = protocolTitle,
			keywords = protocolKeywords.joinToString(separator = ","),
			protocolAbstract = protocolAbstract,
			fileData = file.bytes,
			state = State.PENDING,
			createdAt = Timestamp.valueOf(LocalDateTime.now()),
			academies = emptySet(),
			students = allStudents,
			directors = allDirectors,
			sinodals = emptySet()
		)
		
		val newProtocol = protocolRepository.save(protocol)
		
		allStudents.forEach {
			it.protocols.add(newProtocol)
			studentRepository.save(it)
		}
		
		return newProtocol.toDomain()
	}
}