package com.sgptt.protocolsservice.extension

import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.dto.ProtocolWithFileDTO
import com.sgptt.protocolsservice.model.dto.ProtocolWithoutFileDTO
import com.sgptt.protocolsservice.repository.entity.Protocol

fun Protocol.toDomain(withFile: Boolean = false): ProtocolDTO {
	val protocolWithoutFile = ProtocolWithoutFileDTO(
		id = this.id,
		title = this.title,
		keywords = this.keywords.split(','),
		abstract = this.protocolAbstract,
		state = this.state,
		createdAt = this.createdAt
	)
	return if (withFile) ProtocolWithFileDTO(
		other = protocolWithoutFile,
		fileData = this.fileData
	) else protocolWithoutFile
}