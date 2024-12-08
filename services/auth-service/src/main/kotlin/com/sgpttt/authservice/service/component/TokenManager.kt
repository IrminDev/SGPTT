package com.sgpttt.authservice.service.component

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenManager {
	
	companion object {
		private val SECRET_KEY_STRING = System.getenv("JWT_SECRET")
		private val SECRET_KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY_STRING))
	}
	
	fun createToken(claims: Map<String, Any>): String = Jwts
		.builder()
		.claims(claims)
		.issuedAt(Date())
		.expiration(Date(System.currentTimeMillis() + 1800000L)) // 30 minutes
		.signWith(SECRET_KEY, Jwts.SIG.HS256)
		.compact()
	
}