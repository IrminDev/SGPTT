package com.sgptt.protocolsservice.model.dto

import com.sgptt.protocolsservice.model.State
import java.sql.Timestamp

data class ProtocolDTO(
	val id: Long,
	val title: String,
	val keywords: List<String>,
	val abstract: String,
	val state: State,
	val createdAt: Timestamp,
	val fileUrl: String,
)
