package com.sgpttt.authservice.model.domain

/**
 * This is a sealed class that represents a Person in the system, it has three child
 * Student, Professor and Catt
 * The superclass contains the full person name in property[name] and its [number]
 * (it could be student id, professor number, catt id or null if PersonDTO is instance of [UnauthenticatedPerson])
 * @property name it's the person's full name
 * @property number student if, professor number, catt id or null if the person wasn't found
 * @see Student
 * @see Professor
 * @see CattPerson
 */
sealed class PersonDTO(
	open val name: String,
	open val number: String?, //Student number or Employer ID
) {
	/**
	 * Represents a student
	 * @property career The student's career, it could be ISC, IA or LCD
	 * @property isIrregular true if this student is irregular
	 */
	data class Student(
		val career: Career,
		val isIrregular: Boolean,
		override val name: String,
		override val number: String,
	) : PersonDTO(name, number)
	
	/**
	 * Represents a professor
	 * @property school The name of school this professor works
	 * @property academy The name of academy this professor is
	 */
	data class Professor(
		val school: String,
		val academy: String,
		override val name: String,
		override val number: String,
	) : PersonDTO(name, number)
	
	/**
	 * Represents a Catt person
	 * @property role The catt person's role, it could be COORDINATOR, ASSISTANT, ADMINISTRATOR or SECRETARY
	 */
	data class CattPerson(
		override val name: String,
		override val number: String,
		val role: Role,
	) : PersonDTO(name, number)
	
	/**
	 * Represents an inactive person in the system, this DTO is given if the field isActive into database is true
	 */
	data class InactivePerson(override val name: String, override val number: String) : PersonDTO(name, number)
	
	/**
	 * Represents an unauthenticated person, typically if who is trying to make login wrote its password incorrectly
	 */
	data class UnauthenticatedPerson(override val name: String) : PersonDTO(name, null)
}
