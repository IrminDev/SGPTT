package com.sgptt.protocolsservice.repository.entity

import com.sgptt.protocolsservice.model.Career
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.PrimaryKeyJoinColumn
import java.util.*

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
class Student(
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "career", nullable = false)
	val career: Career,
	
	@Column(name = "student_id", nullable = false, length = 10, unique = true)
	val studentNumber: String,
	
	@Column(name = "is_irregular", nullable = false)
	val isIrregular: Boolean,
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "protocol_person",
		joinColumns = [JoinColumn(name = "protocol_id")],
		inverseJoinColumns = [JoinColumn(name = "person_id")]
	)
	val protocols: MutableSet<Protocol>,
	
	personId: Long,
	name: String,
	paternalSurname: String,
	maternalSurname: String,
	email: String,
	password: String,
	createdAt: Date,
	isActive: Boolean

) : Person(personId, name, paternalSurname, maternalSurname, email, password, createdAt, isActive)