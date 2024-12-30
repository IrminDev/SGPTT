package com.sgptt.protocolsservice.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Constraint(validatedBy = [EnrollmentValidator::class])
annotation class AllEnrollment(
	val message: String = "Any enrollment number isn't valid",
	val groups: Array<KClass<*>> = [],
	val payload: Array<KClass<out Payload>> = []
)
