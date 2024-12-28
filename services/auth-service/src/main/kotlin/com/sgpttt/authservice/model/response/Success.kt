package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonDTO

/**
 * This class represents a login attempt that was successfully
 * @property person a DTO object
 * @property token a JWT token witch user will use to get api resources if it is authorized
 * the token contains personId and its role in payload and also exp and iat values
 */
data class Success(
	override val person: PersonDTO,
	val token: String
): LoginResponse(person, result = "Success")
