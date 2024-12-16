package com.sgpttt.authservice.model.domain

sealed class PersonDTO(
	open val name: String,
	open val number: String?, //Student number or Employer ID
	open val isActive: Boolean
) {
	data class Student(
		val career: Career,
		val recursor: Boolean,
		override val name: String,
		override val number: String,
		override val isActive: Boolean
	) :
		PersonDTO(name, number, isActive)
	
	data class Professor(
		val school: String,
		val academy: String,
		override val name: String,
		override val number: String,
		override val isActive: Boolean
	) :
		PersonDTO(name, number, isActive)
	
	data class CattPerson(
		override val name: String,
		override val number: String,
		val role: CattRole,
		override val isActive: Boolean
	) :
		PersonDTO(name, number, isActive)
	
	data class InactivePerson(override val name: String, override val number: String?) : PersonDTO(name, number, false)
	
	data class UnauthenticatedPerson(override val name: String) : PersonDTO(name, null, true)
}
