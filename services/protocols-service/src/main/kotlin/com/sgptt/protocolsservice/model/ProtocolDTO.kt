package com.sgptt.protocolsservice.model

import com.sgptt.protocolsservice.repository.entity.model.ProtocolState
import java.sql.Timestamp

data class ProtocolDTO(
	val id: Long,
	val title: String,
	val keywords: List<String>,
	val abstract: String,
	val fileDataBase64: String,
	val state: ProtocolState,
	val uploadAt: Timestamp
)
