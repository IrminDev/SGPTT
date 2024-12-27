package com.sgpttt.authservice.repository.entity

import com.sgpttt.authservice.model.domain.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.PrimaryKeyJoinColumn
import java.util.Date

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
class Catt(
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "role", nullable = false)
	val role: Role,
	@Column(name = "catt_id")
	val cattId: String,
	
	personId: Long,
	name: String,
	paternalSurname: String,
	maternalSurname: String,
	email: String,
	password: String,
	createdAt: Date,
	isActive: Boolean

) : Person(personId, name, paternalSurname, maternalSurname, email, password, createdAt, isActive)