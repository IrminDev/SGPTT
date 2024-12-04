package com.sgpttt.authservice.repository.model


interface LoginResult {
    val wrongPassword: Boolean
    val personId: Int
}

