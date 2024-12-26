package com.sgptt.protocolsservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.sql.Timestamp

@Entity
@Table(name = "person")
data class Person(
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	val id: Long,
	
	@Column(name = "name", length = 50)
	val name: String,
	
	@Column(name = "paternal_surname", length = 50)
	val paternalSurname: String,
	
	@Column(name = "maternal_surname", length = 50)
	val maternalSurname: String,
	
	@Column(name = "email", length = 100, unique = true)
	val email: String,
	
	@Column(name = "password", length = 50)
	val password: String,
	
	@Column(name = "created_at", columnDefinition = "timestamp default current_timestamp")
	val createdAt: Timestamp,
	
	@Column(name = "is_active", columnDefinition = "boolean default true")
	val isActive: Boolean,
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = PersonRole::class)
	@JoinColumn(name = "role_id")
	val role: PersonRole
)