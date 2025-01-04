package com.sgpttt.authservice.model.response

/**
 * A Not found result that extends of [LoginResponse], it overrides [person] property with null
 */
data object NotFound: LoginResponse(person = null, result = "Person not found")