package com.sgptt.protocolsservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Sinodal(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long,
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	val professor: Professor,
	
	@Column(name = "is_sinodal", nullable = false, columnDefinition = "boolean default true")
	val isSinodal: Boolean,
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "protocol_id")
	val protocol: Protocol*/
)
