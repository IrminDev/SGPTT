package com.sgptt.protocolsservice.interceptor

import com.sgptt.protocolsservice.interceptor.model.PayloadResponse
import com.sgptt.protocolsservice.model.Role
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.servlet.HandlerInterceptor

@Component(value = "auth-interceptor")
class AuthInterceptor(restClientBuilder: RestClient.Builder) : HandlerInterceptor {
	
	private val restClient: RestClient = restClientBuilder
		.baseUrl("http://auth-service:8090")
		.build()
	
	protected val authorizedRole: Role = Role.CATT
	
	override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
		
		return request.getHeader("Authorization")?.let {
			if (!it.startsWith("Bearer")) {
				response.status = HttpStatus.BAD_REQUEST.value()
				return@let false
			}
			val payload: PayloadResponse = restClient
				.get()
				.uri("/api/auth/authorize/{role}", authorizedRole)
				.headers { httpHeader ->
					httpHeader.set("Authorization", it)
				}
				.retrieve()
				.onStatus(HttpStatusCode::is4xxClientError) { _, authResponse ->
					response.status = authResponse.statusCode.value()
				}
				.body(PayloadResponse::class.java) ?: PayloadResponse(isAuthorized = false, personId = -1)
			payload.isAuthorized.also { isAuth ->
				if (isAuth) request.setAttribute("personId", payload.personId)
			}
		} ?: run {
				response.status = HttpStatus.UNAUTHORIZED.value()
				false
			}
	}
	
}