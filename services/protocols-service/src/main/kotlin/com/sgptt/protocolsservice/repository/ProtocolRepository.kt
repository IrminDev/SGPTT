package com.sgptt.protocolsservice.repository

import com.sgptt.protocolsservice.repository.entity.Protocol
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param

interface ProtocolRepository : PagingAndSortingRepository<Protocol, Long>, JpaRepository<Protocol, Long> {
	
	@Query(
		nativeQuery = true,
		value = "select p.protocol_id, p.title, p.keywords, p.abstract, p.created_at, p.state, p.file_data" +
				" from protocol p left join protocol_student ps on p.protocol_id = ps.protocol_id" +
				" where ps.person_id = :student_id"
	)
	fun findAllByStudentId(@Param("student_id") studentId: Long): List<Protocol>
	
	@Query(
		nativeQuery = true,
		value = "select p.protocol_id, p.title, p.keywords, p.abstract, p.created_at, p.state, p.file_data" +
				" from protocol p left join director d on p.protocol_id = d.protocol_id" +
				" where d.person_id = :professor_id"
	)
	fun findAllByProfessorId(@Param("professor_id") professorId: Long): List<Protocol>
	
	@Query(
		nativeQuery = true,
		value = "select p.protocol_id, p.created_at, p.file_data, p.keywords, p.abstract, p.state, p.title" +
				" from protocol p left join sinodal s on p.protocol_id = s.protocol_id" +
				" where s.person_id = :synodal_id and s.is_sinodal"
	)
	fun findBySynodalId(@Param("synodal_id") id: Long): List<Protocol>
	
	@Query(
		nativeQuery = true,
		value = "select p.protocol_id, p.created_at, p.file_data, p.keywords, p.abstract, p.state, p.title" +
				" from protocol p inner join protocol_academy on p.protocol_id = protocol_academy.protocol_id" +
				" left join academy a on protocol_academy.academy_id = a.academy_id" +
				" left join sinodal on p.protocol_id = sinodal.protocol_id" +
				" where a.name = :academy group by a.name, p.protocol_id having count(sinodal.id) < 3;"
	)
	fun findAllSuggestionByProfessorAcademy(@Param("academy") academy: String): List<Protocol>
	
	@Query(
		nativeQuery = true,
		value = "select p.protocol_id, p.created_at, p.file_data, p.keywords, p.abstract, p.state, p.title" +
			" from protocol p left join sinodal on p.protocol_id = sinodal.protocol_id" +
			" group by p.protocol_id, p.created_at, p.file_data, p.keywords, p.abstract, p.state, p.title" +
				" having count(sinodal.protocol_id) < 3;"
	)
	fun findAllBySinodalsCountIsLessThan3(): List<Protocol>
	
	@Query(
		nativeQuery = true,
		value = "select p.protocol_id, p.created_at, p.file_data, p.keywords, p.abstract, p.state, p.title" +
			" from protocol p left join sinodal on p.protocol_id = sinodal.protocol_id" +
			" group by p.protocol_id, p.created_at, p.file_data, p.keywords, p.abstract, p.state, p.title" +
				" having count(sinodal.protocol_id) = 3;"
	)
	fun findAllBySinodalAreFull(): List<Protocol>
}