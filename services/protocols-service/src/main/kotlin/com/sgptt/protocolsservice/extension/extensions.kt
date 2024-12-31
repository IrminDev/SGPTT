package com.sgptt.protocolsservice.extension

import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.dto.ProtocolWithFileDTO
import com.sgptt.protocolsservice.model.dto.ProtocolWithoutFileDTO
import com.sgptt.protocolsservice.repository.entity.Protocol
import org.springframework.validation.BindingResult

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
		fileData = this.fileData,
		students = this.students.map { s -> "${s.name} ${s.paternalSurname} ${s.maternalSurname}" },
		directors = this.directors.map { d -> "${d.name} ${d.paternalSurname} ${d.maternalSurname}" }
	) else protocolWithoutFile
}

fun BindingResult.buildErrorMessage() = buildString {
	fieldErrors.forEach { error ->
		append("${error.field}: ${error.defaultMessage} ")
		append('\n')
	}
}