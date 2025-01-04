package com.sgptt.protocolsservice.security

import com.sgptt.protocolsservice.model.dto.AuthDTO
import jakarta.servlet.http.HttpServletRequest
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestClient

@Aspect
@Component
class RoleCheckAspect @Autowired constructor(
	private val restClientBuilder: RestClient.Builder,
	private val request: HttpServletRequest,
) {
	@Value("\${env.data.auth.url}")
	private lateinit var authServiceUrl: String
	
	@Before("@annotation(requiresRole)")
	@Throws(SecurityException::class)
	fun checkRole(requiresRole: RequiresRole) {
		val token = request.getHeader("Authorization")
		if (token == null || token.isEmpty()) {
			throw SecurityException("Token not found")
		}
		val response: ResponseEntity<AuthDTO?>
		val request = restClientBuilder.baseUrl(authServiceUrl).build()
		try {
			response = request.get().uri("/api/auth/authorize/me").headers { headers: HttpHeaders ->
				headers.add(
					"Authorization",
					token
				)
			}.retrieve().toEntity(AuthDTO::class.java)
		} catch (e: HttpClientErrorException) {
			if (e.statusCode === HttpStatus.UNAUTHORIZED) {
				throw SecurityException("Unauthorized: Invalid token")
			} else {
				throw SecurityException("Error during authorization")
			}
		} catch (e: Exception) {
			throw SecurityException("Error during authorization")
		}
		
		if (response.body == null) {
			throw SecurityException("Invalid token")
		}
		
		val roles = requiresRole.roles
		
		for (requiredRole in roles) {
			if (response.body!!.role == requiredRole)
				return
		}
		
		throw SecurityException("Unauthorized")
	}
}