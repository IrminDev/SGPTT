package com.sgptt.protocolsservice.model.dto

import com.sgptt.protocolsservice.model.ProtocolState
import java.sql.Timestamp

data class ProtocolWithoutFileDTO(
	override val id: Long,
	override val title: String,
	override val keywords: List<String>,
	override val abstract: String,
	override val state: ProtocolState,
	override val uploadAt: Timestamp
) : ProtocolDTO
