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
@Table(name = "protocol")
data class Protocol(
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "protocol_id")
	val id: Long,
	
	@Column(name = "title", nullable = false, length = 255)
	val title: String,
	
	@Column(name = "keywords", nullable = false, columnDefinition = "text")
	val keyword: String,
	
	@Column(name = "abstract", nullable = false, columnDefinition = "text")
	val abstract: String,
	
	@Column(name = "file_data", nullable = false, columnDefinition = "bytea")
	val fileData: ByteArray,
	
	@ManyToOne(targetEntity = ProtocolState::class, fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id", nullable = false)
	val protocolState: ProtocolState,
	
	@Column(name = "upload_at", nullable = false, columnDefinition = "timestamp")
	val uploadAt: Timestamp
) {
	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is Protocol) return false
		
		if (id != other.id) return false
		if (title != other.title) return false
		if (keyword != other.keyword) return false
		if (abstract != other.abstract) return false
		if (!fileData.contentEquals(other.fileData)) return false
		if (protocolState != other.protocolState) return false
		if (uploadAt != other.uploadAt) return false
		
		return true
	}
	
	override fun hashCode(): Int {
		var result = id.hashCode()
		result = 31 * result + title.hashCode()
		result = 31 * result + keyword.hashCode()
		result = 31 * result + abstract.hashCode()
		result = 31 * result + fileData.contentHashCode()
		result = 31 * result + protocolState.hashCode()
		result = 31 * result + uploadAt.hashCode()
		return result
	}
}
