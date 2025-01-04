package com.sgpttt.authservice.model.response

import com.sgpttt.authservice.model.domain.PersonDTO

/**
 * This is a class that represents an authentication result when any person is trying to get into the system
 * @property person An DTO object with contains superficial information about the user, it can be null if the
 * authentication attempt was unsuccessfully with a not found result
 *
 * @property result a simple message about the authentication result
 *
 * @see Success
 * @see WrongPassword
 * @see InactiveResponse
 * @see NotFound
 */
sealed class LoginResponse(open val person: PersonDTO?, open val result: String)