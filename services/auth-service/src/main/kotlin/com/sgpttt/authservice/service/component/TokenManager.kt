package com.sgpttt.authservice.service.component

import com.sgpttt.authservice.model.domain.PersonRole
import com.sgpttt.authservice.model.response.PayloadResponse
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
		.expiration(Date(System.currentTimeMillis() + 36_000_00L)) // 1 hour
		.signWith(SECRET_KEY, Jwts.SIG.HS256)
		.compact()
	
	fun getPayloadIfTokenIsNonExpiredAndHasRole(token: String, role: PersonRole): PayloadResponse {
		val claims = try {
			Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token)
		} catch (e: JwtException) {
			return PayloadResponse(isAuthorized = false, personId = -1)
		}
		val (roleInPayload, personIdInPayload) = with(claims.payload) {
			PersonRole.valueOf(this["role"] as String) to this["personId"] as Number
		}
		val timeExpired = claims.payload["exp"] as Long
		val dateExpire = Date(timeExpired * 1000L)
		val currentDate = Date(System.currentTimeMillis())
		return PayloadResponse(
			isAuthorized = roleInPayload == role && currentDate.before(dateExpire),
			personId = personIdInPayload.toLong()
		)
		
	}
	
}