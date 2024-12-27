package com.sgpttt.authservice.repository.entity

import com.sgpttt.authservice.model.domain.State
import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
data class ChangeRequest (
	// Getters and Setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id")
	val requestId: Long,
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "format_data", columnDefinition = "bytea", nullable = false)
	val formatData: ByteArray,
	
	@Column(name = "request_comments", columnDefinition = "text", nullable = false)
	val requestComments: String,
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	val createdAt: Date,
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "state", nullable = false)
	val state: State,
	
	@ManyToOne
	@JoinColumn(name = "protocol_id")
	val protocol: Protocol,
) {
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is ChangeRequest) return false
		
		if (requestId != other.requestId) return false
		if (!formatData.contentEquals(other.formatData)) return false
		if (requestComments != other.requestComments) return false
		if (createdAt != other.createdAt) return false
		if (state != other.state) return false
		if (protocol != other.protocol) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = requestId.hashCode()
		result = 31 * result + formatData.contentHashCode()
		result = 31 * result + requestComments.hashCode()
		result = 31 * result + createdAt.hashCode()
		result = 31 * result + state.hashCode()
		result = 31 * result + protocol.hashCode()
		return result
	}
}
