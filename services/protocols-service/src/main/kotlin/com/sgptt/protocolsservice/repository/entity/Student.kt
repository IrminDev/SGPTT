package com.sgptt.protocolsservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "student")
data class Student(
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	val id: Long,
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Person::class)
	@JoinColumn(name = "person_id")
	val person: Person,
	
	@Column(name = "student_number", length = 20, unique = true)
	val studentNumber: String,
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "career_id")
	val career: Career,
	
	@Column(name = "recursor", columnDefinition = "boolean default false")
	val recursor: Boolean
	
)
