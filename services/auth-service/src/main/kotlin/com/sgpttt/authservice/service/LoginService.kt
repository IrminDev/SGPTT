package com.sgpttt.authservice.service

import com.sgpttt.authservice.model.domain.PersonDTO
import com.sgpttt.authservice.model.response.InactiveResponse
import com.sgpttt.authservice.model.response.LoginResponse
import com.sgpttt.authservice.model.response.NotFound
import com.sgpttt.authservice.model.response.Success
import com.sgpttt.authservice.model.response.WrongPassword
import com.sgpttt.authservice.repository.PersonRepository
import com.sgpttt.authservice.repository.model.Role
import com.sgpttt.authservice.service.component.GetRepository
import org.springframework.stereotype.Service

/*TODO( Add JWT for authenticated users )*/

@Service
class LoginService(
	private val personRepository: PersonRepository,
	private val getRepository: GetRepository
) {
	
	fun getPersonByEmailAndPassword(email: String, password: String): LoginResponse {
		val loginResult = personRepository.login(email, password)
		if (loginResult.personId == -1) return NotFound
		
		val personDb = personRepository.findById(loginResult.personId).get()
		
		val person = getRepository(Role.valueOf(personDb.role.name)).findById(personDb.personId).get().toDomain()
		
		if (!person.isActive)
			return InactiveResponse(PersonDTO.InactivePerson(name = person.name, number = person.number))
		
		if (loginResult.wrongPassword)
			return WrongPassword(PersonDTO.UnauthenticatedPerson(name = person.name))
		
		return Success(person, token = "token")
		
	}
	
}