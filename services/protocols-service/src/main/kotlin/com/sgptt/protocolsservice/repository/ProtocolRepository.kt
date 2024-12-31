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
}