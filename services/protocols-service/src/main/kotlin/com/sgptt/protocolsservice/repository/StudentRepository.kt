package com.sgptt.protocolsservice.repository

import com.sgptt.protocolsservice.repository.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
	fun existsStudentByStudentNumber(studentNumber: String): Boolean
	fun findByStudentNumber(studentNumber: String): Student
}