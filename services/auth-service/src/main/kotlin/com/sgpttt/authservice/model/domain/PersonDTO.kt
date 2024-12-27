package com.sgpttt.authservice.model.domain

sealed class PersonDTO(
	open val name: String,
	open val number: String?, //Student number or Employer ID
) {
	data class Student(
		val career: Career,
		val isIrregular: Boolean,
		override val name: String,
		override val number: String,
	) : PersonDTO(name, number)
	
	data class Professor(
		val school: String,
		val academy: String,
		override val name: String,
		override val number: String,
	) : PersonDTO(name, number)
	
	data class CattPerson(
		override val name: String,
		override val number: String,
		val role: Role,
	) : PersonDTO(name, number)
	
	data class InactivePerson(override val name: String, override val number: String?) : PersonDTO(name, number)
	
	data class UnauthenticatedPerson(override val name: String) : PersonDTO(name, null)
}
