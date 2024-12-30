package com.sgptt.protocolsservice.model.dto

import com.sgptt.protocolsservice.model.State
import java.sql.Timestamp

data class ProtocolWithoutFileDTO(
	override val id: Long,
	override val title: String,
	override val keywords: List<String>,
	override val abstract: String,
	override val state: State,
	override val createdAt: Timestamp
) : ProtocolDTO
