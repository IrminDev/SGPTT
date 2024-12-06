package com.sgpttt.authservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "catt_role")
data class CATTRole(
	@Id
	@Column(name = "catt_role_id")
	val cattRoleId: Int,
	
	@Column(name = "catt_role_name")
	val cattRoleName: String
)
