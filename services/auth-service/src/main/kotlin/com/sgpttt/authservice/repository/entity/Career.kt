package com.sgpttt.authservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Career(
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "career_id")
	val careerId: Long,
	
	val name: String
)