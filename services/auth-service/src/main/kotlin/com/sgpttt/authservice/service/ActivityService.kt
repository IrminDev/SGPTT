package com.sgpttt.authservice.service

import com.sgpttt.authservice.extension.toDomain
import com.sgpttt.authservice.model.domain.ActivityDTO
import com.sgpttt.authservice.repository.ActivityRepository
import org.springframework.stereotype.Service

@Service
class ActivityService(private val repository: ActivityRepository) {

	val allOpenDates: List<ActivityDTO>
		get() = repository.findAllByOpenDateLessThanEqual().map { it.toDomain() }

}