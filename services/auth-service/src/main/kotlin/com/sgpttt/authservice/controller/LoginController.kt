package com.sgpttt.authservice.controller

import com.sgpttt.authservice.model.domain.PersonRole
import com.sgpttt.authservice.model.request.LoginRequest
import com.sgpttt.authservice.model.response.InactiveResponse
import com.sgpttt.authservice.model.response.LoginResponse
import com.sgpttt.authservice.model.response.NotFound
import com.sgpttt.authservice.model.response.PayloadResponse
import com.sgpttt.authservice.model.response.Success
import com.sgpttt.authservice.model.response.WrongPassword
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
	/**
	 * Endpoint to make login into the system
	 * @param loginRequest is the object that you must send to this endpoint with POST method
	 * @return An object that extends of LoginResponse, it contains a Person DTO object and a message about the result
	 * @see LoginRequest
	 * @see LoginResponse
	 */
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
		request: HttpServletRequest, @PathVariable role: PersonRole
	): ResponseEntity<PayloadResponse> {
		
		val token =
			request.getHeader("Authorization")?.substring(7)
				?: return ResponseEntity(PayloadResponse(
					isAuthorized = false,
					personId = -1,
				), HttpStatus.UNAUTHORIZED)
		
		return with(loginService.isAuthorized(token, role)) {
			ResponseEntity(
				this,
				when (this.isAuthorized) {
					true -> HttpStatus.OK
					false -> HttpStatus.FORBIDDEN
				}
			)
		}
	}
}
