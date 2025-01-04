package com.sgptt.protocolsservice.repository

import com.sgptt.protocolsservice.model.ActivityName
import com.sgptt.protocolsservice.repository.entity.Activity
import org.springframework.data.jpa.repository.JpaRepository

interface ActivityRepository : JpaRepository<Activity, Long> {
	fun findByActivity(activity: ActivityName): Activity
}