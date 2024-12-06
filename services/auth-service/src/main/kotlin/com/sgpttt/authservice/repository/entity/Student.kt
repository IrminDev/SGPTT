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
data class Student(
	@Id
	@Column(name = "person_id")
	val personId: Long,
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "person_id")
	val person: Person,
	
	@ManyToOne
	@JoinColumn(name = "career_id")
	val career: Career,
	
	@Column(name = "student_number")
	val studentNumber: String

) : DomainDTO<PersonDTO> {
	
	override fun toDomain(): PersonDTO.Student {
		return PersonDTO.Student(
			career = enumValueOf<com.sgpttt.authservice.model.domain.Career>(career.name),
			name = "${person.name} ${person.paternalSurname} ${person.maternalSurname}",
			number = studentNumber,
			isActive = person.isActive
		)
	}
}