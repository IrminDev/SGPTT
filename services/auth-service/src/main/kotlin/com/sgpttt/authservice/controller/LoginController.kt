package com.sgpttt.authservice.controller

import com.sgpttt.authservice.model.request.LoginRequest
import com.sgpttt.authservice.model.response.InactiveResponse
import com.sgpttt.authservice.model.response.LoginResponse
import com.sgpttt.authservice.model.response.NotFound
import com.sgpttt.authservice.model.response.Success
import com.sgpttt.authservice.model.response.WrongPassword
import com.sgpttt.authservice.service.LoginService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class LoginController(private val loginService: LoginService) {
	
	@PostMapping("/login")
	fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
		val (email, password) = loginRequest
		val response = loginService.getPersonByEmailAndPassword(email, password)
		val statusCode = when (response) {
			is InactiveResponse -> HttpStatus.ACCEPTED
			NotFound -> HttpStatus.NOT_FOUND
			is Success -> HttpStatus.OK
			is WrongPassword -> HttpStatus.NOT_ACCEPTABLE
		}
		return ResponseEntity(response, statusCode)
	}
}