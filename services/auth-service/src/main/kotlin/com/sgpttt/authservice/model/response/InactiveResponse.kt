package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonDTO

data class InactiveResponse(
	override val person: PersonDTO
) : LoginResponse(person, result = "Inactive person")
