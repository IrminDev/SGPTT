package com.sgptt.protocolsservice.extension

import com.sgptt.protocolsservice.model.dto.AcademyDTO
import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.repository.entity.Person
import com.sgptt.protocolsservice.repository.entity.Protocol
import com.sgptt.protocolsservice.repository.entity.Sinodal
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
		fileUrl = "${protocolUrl}${this.id}",
		students = buildList {
			val iter = this@toDomain.students.iterator()
			while (iter.hasNext()) {
				add(iter.next().fullName)
			}
		},
		directors = buildList {
			val iter = this@toDomain.directors.iterator()
			while (iter.hasNext()) {
				add(iter.next().fullName)
			}
		},
		synodales = buildList {
			val iter = this@toDomain.sinodals.iterator()
			while (iter.hasNext()) {
				add(iter.next().fullName)
			}
		},
		academies = buildList {
			val iter = this@toDomain.academies.iterator()
			while (iter.hasNext()) {
				val academy = iter.next()
				add(AcademyDTO(academy.academyId, academy.name))
			}
		}
	)
}

fun BindingResult.buildErrorMessage() = buildString {
	fieldErrors.forEach { error ->
		append("${error.field}: ${error.defaultMessage} ")
		append('\n')
	}
}

internal val Person.fullName: String
	get() = "$name $paternalSurname $maternalSurname"

internal val Sinodal.fullName: String
	get() = professor.fullName