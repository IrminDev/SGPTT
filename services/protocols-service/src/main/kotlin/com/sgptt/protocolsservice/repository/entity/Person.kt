package com.sgptt.protocolsservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Person(
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id", nullable = false)
	val personId: Long,
	
	@Column(name = "name", nullable = false, length = 50)
	val name: String,
	
	@Column(name = "paternal_surname", nullable = false, length = 50)
	val paternalSurname: String,
	
	@Column(name = "maternal_surname", nullable = false, length = 50)
	val maternalSurname: String,
	
	@Column(name = "email", nullable = false, length = 70, unique = true)
	val email: String,
	
	@Column(name = "password", nullable = false, length = 100)
	val password: String,
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	val createdAt: Date,
	
	@Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	val isActive: Boolean
	
)