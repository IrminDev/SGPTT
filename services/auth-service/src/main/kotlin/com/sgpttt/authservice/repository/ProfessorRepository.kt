package com.sgpttt.authservice.repository

import com.sgpttt.authservice.repository.entity.Professor
import org.springframework.data.jpa.repository.JpaRepository

interface ProfessorRepository : JpaRepository<Professor, Long> {
}