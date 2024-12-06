package com.sgpttt.authservice.service.component

import com.sgpttt.authservice.model.domain.PersonDTO
import com.sgpttt.authservice.repository.CattRepository
import com.sgpttt.authservice.repository.DomainDTO
import com.sgpttt.authservice.repository.ProfessorRepository
import com.sgpttt.authservice.repository.StudentRepository
import com.sgpttt.authservice.repository.model.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component


@Component
class GetRepository(
	@Autowired private val studentRepository: StudentRepository,
	@Autowired private val professorRepository: ProfessorRepository,
	@Autowired private val cattRepository: CattRepository
) {
	operator fun invoke(role: Role): JpaRepository<out DomainDTO<out PersonDTO>, Long> =
		when (role) {
			Role.Estudiante -> studentRepository
			Role.Profesor -> professorRepository
			Role.CATT -> cattRepository
		}
	
}