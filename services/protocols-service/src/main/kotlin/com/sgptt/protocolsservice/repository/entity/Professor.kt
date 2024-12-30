package com.sgptt.protocolsservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.PrimaryKeyJoinColumn
import java.util.*

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
class Professor(
	
	@Column(name = "professor_number", nullable = false, length = 10)
	val professorNumber: String,
	
	@ManyToOne(targetEntity = Academy::class, fetch = FetchType.LAZY)
	@JoinColumn(name = "academy_id")
	val academy: Academy,
	
	@Column(name = "school", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'ESCOM'")
	val school: String,
	
	personId: Long,
	name: String,
	paternalSurname: String,
	maternalSurname: String,
	email: String,
	password: String,
	createdAt: Date,
	isActive: Boolean

) : Person(personId, name, paternalSurname, maternalSurname, email, password, createdAt, isActive)
