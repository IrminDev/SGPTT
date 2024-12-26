package com.sgptt.protocolsservice.model.dto

import com.sgptt.protocolsservice.model.ProtocolState
import java.sql.Timestamp

interface ProtocolDTO {
	val id: Long
	val title: String
	val keywords: List<String>
	val abstract: String
	val state: ProtocolState
	val uploadAt: Timestamp
}