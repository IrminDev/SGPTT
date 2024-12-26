package com.sgptt.protocolsservice.repository.entity

import com.sgptt.protocolsservice.model.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "role")
data class PersonRole(
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	val id: Int,
	
	@Enumerated(EnumType.STRING)
	@Column(name = "name", length = 50)
	val role: Role
)