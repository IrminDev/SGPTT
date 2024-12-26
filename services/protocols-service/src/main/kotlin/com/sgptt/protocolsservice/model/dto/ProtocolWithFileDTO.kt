package com.sgptt.protocolsservice.model.dto

import com.sgptt.protocolsservice.model.ProtocolState
import java.sql.Timestamp
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

data class ProtocolWithFileDTO(
	override val id: Long,
	override val title: String,
	override val keywords: List<String>,
	override val abstract: String,
	override val state: ProtocolState,
	override val uploadAt: Timestamp,
	val fileDataBase64: String,
) : ProtocolDTO {
	@OptIn(ExperimentalEncodingApi::class)
	constructor(other: ProtocolWithoutFileDTO, fileData: ByteArray) : this(
		id = other.id,
		title = other.title,
		keywords = other.keywords,
		abstract = other.abstract,
		state = other.state,
		uploadAt = other.uploadAt,
		fileDataBase64 = Base64.encode(fileData),
	)
}