package com.sgpttt.authservice.repository

import com.sgpttt.authservice.repository.entity.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
}