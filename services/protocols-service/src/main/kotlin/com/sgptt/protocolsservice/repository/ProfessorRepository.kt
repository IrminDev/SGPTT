package com.sgptt.protocolsservice.repository

import com.sgptt.protocolsservice.repository.entity.Professor
import org.springframework.data.jpa.repository.JpaRepository

interface ProfessorRepository : JpaRepository<Professor, Long> {
	fun existsProfessorByProfessorNumber(number: String): Boolean
	fun findByProfessorNumber(number: String): Professor
}