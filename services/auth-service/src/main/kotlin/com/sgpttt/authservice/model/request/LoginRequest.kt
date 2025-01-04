package com.sgpttt.authservice.model.request

/**
 * Simple data class that represents a login request
 * @property email The email witch the user wants to get into the system
 * @property password The user's password
 */
data class LoginRequest(
    val email: String,
    val password: String
)
