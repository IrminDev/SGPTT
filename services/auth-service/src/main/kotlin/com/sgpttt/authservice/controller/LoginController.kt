package com.sgpttt.authservice.controller

import com.sgpttt.authservice.model.LoginRequest
import com.sgpttt.authservice.repository.model.UserResult
import com.sgpttt.authservice.service.LoginService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class LoginController(private val loginService: LoginService) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<UserResult> {
        val (email, password) = loginRequest
        return ResponseEntity.ok(loginService.getPersonByEmailAndPassword(email, password))
    }
}