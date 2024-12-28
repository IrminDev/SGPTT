package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonRole

/**
 * Class to represent the content of token payload
 * @property role The role of this person
 * @property personId the person's id into the database
 */
data class PayloadResponse(
	val role: PersonRole,
	val personId: Long,
)
