package com.sgpttt.authservice.service

import com.sgpttt.authservice.extension.toDomain
import com.sgpttt.authservice.model.domain.PersonDTO
import com.sgpttt.authservice.model.response.InactiveResponse
import com.sgpttt.authservice.model.response.LoginResponse
import com.sgpttt.authservice.model.response.NotFound
import com.sgpttt.authservice.model.response.PayloadResponse
import com.sgpttt.authservice.model.response.Success
import com.sgpttt.authservice.model.response.WrongPassword
import com.sgpttt.authservice.repository.PersonRepository
import com.sgpttt.authservice.repository.entity.Catt
import com.sgpttt.authservice.repository.entity.Professor
import com.sgpttt.authservice.repository.entity.Student
import com.sgpttt.authservice.service.component.TokenManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService(
	@Autowired private val personRepository: PersonRepository,
	@Autowired private val tokenManager: TokenManager
) {
	
	fun getPersonByEmailAndPassword(email: String, password: String): LoginResponse {
		val loginResult = personRepository.login(email, password)
		if (loginResult.personId == -1L) return NotFound
		
		val personDb = personRepository.findById(loginResult.personId).get()
		val personNumber = when (personDb) {
			is Catt -> personDb.cattId
			is Professor -> personDb.professorNumber
			is Student -> personDb.studentNumber
			else -> throw IllegalArgumentException("Unknown person type ${personDb.javaClass.canonicalName}")
		}
		val fullName = with(personDb) { "$name $paternalSurname $maternalSurname" }
		if (!personDb.isActive)
			return InactiveResponse(PersonDTO.InactivePerson(name = fullName, number = personNumber))
		
		if (loginResult.wrongPassword)
			return WrongPassword(PersonDTO.UnauthenticatedPerson(name = fullName))
		
		val claims = mapOf(
			"personId" to personDb.personId,
			"role" to personDb.javaClass.simpleName
		)
		
		return Success(personDb.toDomain(), token = tokenManager.createToken(claims))
		
	}
	
	fun getTokenPayload(token: String): PayloadResponse? =
		tokenManager.getPayloadIfTokenIsNonExpired(token)
	
}