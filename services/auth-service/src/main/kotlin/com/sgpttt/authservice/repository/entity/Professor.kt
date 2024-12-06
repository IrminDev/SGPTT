package com.sgpttt.authservice.repository.entity

import com.sgpttt.authservice.model.domain.PersonDTO
import com.sgpttt.authservice.repository.DomainDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne

@Entity
data class Professor(
	@Id
	@Column(name = "person_id")
	val personId: Long,
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "person_id")
	val person: Person,
	
	@Column(name = "professor_id")
	val professorNumber: String,
	
	@ManyToOne
	@JoinColumn(name = "academy_id")
	val academy: Academy,
	
	val school: String,
) : DomainDTO<PersonDTO> {
	
	override fun toDomain(): PersonDTO.Professor {
		return PersonDTO.Professor(
			school = school,
			academy = academy.name,
			name = "${person.name} ${person.paternalSurname} ${person.maternalSurname}",
			number = professorNumber,
			isActive = person.isActive
		)
	}
}