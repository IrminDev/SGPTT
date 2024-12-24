package com.sgptt.protocolsservice.entension

import com.sgptt.protocolsservice.model.ProtocolDTO
import com.sgptt.protocolsservice.repository.entity.Protocol
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
fun Protocol.toDomain(): ProtocolDTO = ProtocolDTO(
	id = this.id,
	title = this.title,
	keywords = this.keyword.split(','),
	abstract = this.abstract,
	fileDataBase64 = Base64.encode(source = this.fileData),
	state = this.protocolState.state,
	uploadAt = this.uploadAt
)