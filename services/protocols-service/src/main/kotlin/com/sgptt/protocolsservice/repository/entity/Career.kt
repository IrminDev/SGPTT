package com.sgptt.protocolsservice.repository.entity

import com.sgptt.protocolsservice.model.Career
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "career")
data class Career(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "career_id")
	val careerId: Long,
	
	@Enumerated(EnumType.STRING)
	@Column(name = "name", columnDefinition = "varchar(50)", nullable = false)
	val career: Career
)
