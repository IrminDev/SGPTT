package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonDTO

/**
 * If the person who is trying to make login wrote its password incorrectly an object of this class is returned,
 * it overrides [person] property with the person witch was found by its email
 */
data class WrongPassword(override val person: PersonDTO): LoginResponse(person, result = "Wrong password")