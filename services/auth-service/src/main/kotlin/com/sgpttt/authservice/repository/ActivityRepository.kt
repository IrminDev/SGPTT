package com.sgpttt.authservice.repository

import com.sgpttt.authservice.repository.entity.Activity
import java.util.Date
import org.springframework.data.jpa.repository.JpaRepository

interface ActivityRepository : JpaRepository<Activity, Long> {
	
	fun findAllByOpenDateLessThanEqual(date: Date = Date()): List<Activity>
	
}