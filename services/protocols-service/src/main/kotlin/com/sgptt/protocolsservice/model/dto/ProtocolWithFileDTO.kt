package com.sgptt.protocolsservice.model.dto

import com.sgptt.protocolsservice.model.State
import java.sql.Timestamp
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

data class ProtocolWithFileDTO(
	override val id: Long,
	override val title: String,
	override val keywords: List<String>,
	override val abstract: String,
	override val state: State,
	override val createdAt: Timestamp,
	val fileDataBase64: String,
	val students: List<String>,
	val directors: List<String>,
	
	) : ProtocolDTO {
	@OptIn(ExperimentalEncodingApi::class)
	constructor(
		other: ProtocolWithoutFileDTO,
		fileData: ByteArray,
		students: List<String>,
		directors: List<String>,
	) : this(
		id = other.id,
		title = other.title,
		keywords = other.keywords,
		abstract = other.abstract,
		state = other.state,
		createdAt = other.createdAt,
		fileDataBase64 = Base64.encode(fileData),
		students,
		directors
	)
}