package com.sgptt.protocolsservice.extension

import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.repository.entity.Protocol
import org.springframework.validation.BindingResult

private val protocolUrl = System.getenv("DATA_PROTOCOL_URL")

fun Protocol.toDomain(): ProtocolDTO {
	return ProtocolDTO(
		id = this.id,
		title = this.title,
		keywords = this.keywords.split(','),
		abstract = this.protocolAbstract,
		state = this.state,
		createdAt = this.createdAt,
		fileUrl = "${protocolUrl}${this.id}"
	)
}

fun BindingResult.buildErrorMessage() = buildString {
	fieldErrors.forEach { error ->
		append("${error.field}: ${error.defaultMessage} ")
		append('\n')
	}
}