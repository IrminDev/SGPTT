package com.sgpttt.authservice.service

import com.sgpttt.authservice.repository.PersonRepository
import com.sgpttt.authservice.repository.model.LoginResult
import com.sgpttt.authservice.repository.model.UserResult
import org.springframework.stereotype.Service

/*TODO( Add JWT for authenticated users )*/

@Service
class LoginService(private val repository: PersonRepository) {

    private fun getPersonResult(loginResult: LoginResult): UserResult {
        if (loginResult.personId == -1) return UserResult.NotFound
        return with(repository.findById(loginResult.personId).get()) {
            when {
                loginResult.wrongPassword -> UserResult.WrongPassword(name)
                else -> UserResult.AuthenticatedPerson(this)
            }
        }
    }

    fun getPersonByEmailAndPassword(email: String, password: String): UserResult {
        return getPersonResult(repository.login(email, password))
    }

}