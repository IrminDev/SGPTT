package com.sgpttt.authservice.controller

import com.sgpttt.authservice.model.request.LoginRequest
import com.sgpttt.authservice.model.response.InactiveResponse
import com.sgpttt.authservice.model.response.LoginResponse
import com.sgpttt.authservice.model.response.NotFound
import com.sgpttt.authservice.model.response.Success
import com.sgpttt.authservice.model.response.WrongPassword
import com.sgpttt.authservice.repository.model.Role
import com.sgpttt.authservice.service.LoginService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
	
	@GetMapping("/authorize/{role}")
	fun isAuthorized(
		request: HttpServletRequest, @PathVariable role: String
	): ResponseEntity<Boolean> {
		
		val roleEnum = try {
			Role.valueOf(role)
		} catch (e: IllegalArgumentException) {
			return ResponseEntity(false, HttpStatus.BAD_REQUEST)
		}
		
		val token =
			request.getHeader("Authorization")?.substring(7) ?: return ResponseEntity(false, HttpStatus.UNAUTHORIZED)
		
		return with(loginService.isAuthorized(token, roleEnum)) {
			ResponseEntity(
				this, when (this) {
					true -> HttpStatus.OK
					false -> HttpStatus.FORBIDDEN
				}
			)
		}
	}
}
