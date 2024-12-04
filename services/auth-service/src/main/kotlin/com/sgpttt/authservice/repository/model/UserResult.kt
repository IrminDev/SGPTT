package com.sgpttt.authservice.repository.model

import com.sgpttt.authservice.repository.entity.Person

sealed interface UserResult {

    data class AuthenticatedPerson(val person : Person) : UserResult
    data class WrongPassword(val personName : String) : UserResult
    data class InactivePerson(val personName : String) : UserResult
    data object NotFound : UserResult

}