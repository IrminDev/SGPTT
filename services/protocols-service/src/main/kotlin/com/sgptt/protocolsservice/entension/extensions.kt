package com.sgptt.protocolsservice.entension

import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.dto.ProtocolWithFileDTO
import com.sgptt.protocolsservice.model.dto.ProtocolWithoutFileDTO
import com.sgptt.protocolsservice.repository.entity.Protocol

fun Protocol.toDomain(withFile: Boolean = false): ProtocolDTO {
	val protocolWithoutFile = ProtocolWithoutFileDTO(
		id = this.id,
		title = this.title,
		keywords = this.keyword.split(','),
		abstract = this.abstract,
		state = this.protocolState.state,
		uploadAt = this.uploadAt
	)
	return if (withFile) ProtocolWithFileDTO(
		other = protocolWithoutFile,
		fileData = this.fileData
	) else protocolWithoutFile
}