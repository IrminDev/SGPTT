package com.sgptt.protocolsservice.repository.entity

import com.sgptt.protocolsservice.repository.entity.model.ProtocolState
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "protocolstate")
data class ProtocolState(
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id")
	val id: Long,
	
	@Enumerated(EnumType.STRING)
	@Column(name = "name", length = 50)
	val state: ProtocolState
)
