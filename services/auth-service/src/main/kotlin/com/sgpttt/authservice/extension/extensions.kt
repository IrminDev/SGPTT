package com.sgpttt.authservice.extension

import com.sgpttt.authservice.model.domain.ActivityDTO
import com.sgpttt.authservice.model.domain.PersonDTO
import com.sgpttt.authservice.repository.entity.Activity
import com.sgpttt.authservice.repository.entity.Catt
import com.sgpttt.authservice.repository.entity.Person
import com.sgpttt.authservice.repository.entity.Professor
import com.sgpttt.authservice.repository.entity.Student

fun Person.toDomain(): PersonDTO = when (this) {
	is Catt -> PersonDTO.CattPerson(
		name = "${this.name} ${this.paternalSurname} ${this.maternalSurname}",
		number = this.cattId,
		role = this.role
	)
	
	is Professor -> PersonDTO.Professor(
		school = this.school,
		academy = this.academy.name,
		name = "${this.name} ${this.paternalSurname} ${this.maternalSurname}",
		number = this.professorNumber
	)
	
	is Student -> PersonDTO.Student(
		career = this.career,
		number = this.studentNumber,
		isIrregular = this.isIrregular,
		name = "${this.name} ${this.paternalSurname} ${this.maternalSurname}"
	)
	
	else -> throw IllegalArgumentException("Unknown person type")
}

fun Activity.toDomain(): ActivityDTO = ActivityDTO(
	name = activity.name,
	closeDate = closeDate
)