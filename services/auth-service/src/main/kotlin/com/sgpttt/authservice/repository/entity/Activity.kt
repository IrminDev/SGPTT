package com.sgpttt.authservice.repository.entity

import com.sgpttt.authservice.model.domain.ActivityName
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
data class Activity(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_id")
	val activityId: Long,
	
	@Temporal(TemporalType.DATE)
	val openDate: Date,
	
	@Temporal(TemporalType.DATE)
	val closeDate: Date,
	
	@Enumerated(EnumType.ORDINAL)
	val activity: ActivityName,
)
