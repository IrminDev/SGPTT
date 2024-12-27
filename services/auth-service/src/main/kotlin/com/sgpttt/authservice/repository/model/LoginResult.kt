package com.sgpttt.authservice.repository.model

/**
 *   This interface represents a result to try a login
 *   @property[wrongPassword] it's true if the person who is trying to authenticate wrote its password correctly
 *   @property[personId] The person's id who is trying to authenticate, it is -1 if the person wasn't found in the
 *   database, or it put a wrong password
*/
interface LoginResult {
    val wrongPassword: Boolean
    val personId: Long
}

