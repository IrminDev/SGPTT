package com.sgpttt.authservice.repository

import com.sgpttt.authservice.repository.entity.CATT
import org.springframework.data.jpa.repository.JpaRepository

interface CattRepository: JpaRepository<CATT, Long> {
}