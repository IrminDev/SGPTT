package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonDTO

data class Success(
	override val person: PersonDTO,
	val token: String
): LoginResponse(person, result = "Success")
