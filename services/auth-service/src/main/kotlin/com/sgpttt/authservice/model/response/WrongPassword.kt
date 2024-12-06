package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonDTO

data class WrongPassword(override val person: PersonDTO): LoginResponse(person, result = "Wrong password")