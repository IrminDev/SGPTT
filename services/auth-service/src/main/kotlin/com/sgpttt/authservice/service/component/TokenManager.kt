package com.sgpttt.authservice.service.component

import com.sgpttt.authservice.repository.model.Role
import io.jsonwebtoken.JwtException
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
		.expiration(Date(System.currentTimeMillis() + 3600000L)) // 1 hour
		.signWith(SECRET_KEY, Jwts.SIG.HS256)
		.compact()
	
	fun isNonExpiredAndHasRole(token: String, role: Role): Boolean {
		val claims = try {
			Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token)
		} catch (e: JwtException) { return false }
		val roleInPayload = (claims.payload?.get("role") as? String)?.let {Role.valueOf(it) } ?: return false
		val timeExpired = claims.payload?.get("exp") as? Long ?: return false
		val dateExpire = Date(timeExpired * 1000L)
		val currentDate = Date(System.currentTimeMillis())
		return roleInPayload == role && currentDate.before(dateExpire)
	}
	
}