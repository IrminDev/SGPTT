package com.sgptt.protocolsservice.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class EnrollmentValidator : ConstraintValidator<AllEnrollment, List<String>?> {
	
	private val numericRegex = "[0-9]+".toRegex()
	
	override fun isValid(value: List<String>?, context: ConstraintValidatorContext) = value?.let { list ->
		list.all {
			it.length == 10 && numericRegex.matches(it)
		}
	}  ?: true
}