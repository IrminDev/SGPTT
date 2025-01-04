package com.sgptt.protocolsservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
data class Academy(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "academy_id")
	val academyId: Long,
	
	@Column(name = "name", nullable = false, length = 50)
	val name: String,
	
	@ManyToMany(fetch = FetchType.LAZY)
	val protocols: Set<Protocol>
)