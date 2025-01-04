package com.sgptt.protocolsservice.model.exception.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class SecurityExceptionHandler : ControllerExceptionHandler<SecurityException, String> {
	@ExceptionHandler(value = [SecurityException::class])
	override fun handle(e: SecurityException) = ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.message)
}