package com.sgpttt.authservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Academy(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "academy_id")
	val academyId: Long,
	val name: String
)
