package com.sgptt.protocolsservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "activity")
data class Activity(
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activity_id")
	val id: Long,
	
	@Column(name = "open_date", columnDefinition = "DATE", nullable = false)
	val openDate: Date,
	
	@Column(name = "close_date", columnDefinition = "DATE", nullable = false)
	val closeDate: Date,
	
	@Column(name = "activity", length = 50, nullable = false)
	val activity: String,
)
