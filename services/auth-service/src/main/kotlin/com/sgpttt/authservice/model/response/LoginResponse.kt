package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonDTO

sealed class LoginResponse(open val person: PersonDTO?, open val result: String)