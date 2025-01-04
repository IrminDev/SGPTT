package com.sgptt.protocolsservice.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

/**
 * This annotation is used to validate a List<String>
 * all elements in that list must be length 10 and
 * they must be numeric
 *
 * null list is considered valid
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Constraint(validatedBy = [EnrollmentValidator::class])
annotation class AllEnrollment(
	val message: String = "Any enrollment number isn't valid",
	val groups: Array<KClass<*>> = [],
	val payload: Array<KClass<out Payload>> = []
)
