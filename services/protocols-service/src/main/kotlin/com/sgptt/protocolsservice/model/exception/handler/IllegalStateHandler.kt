package com.sgptt.protocolsservice.model.exception.handler

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class IllegalStateHandler : ControllerExceptionHandler<IllegalStateException, String> {
	@ExceptionHandler(value = [IllegalStateException::class])
    override fun handle(e: IllegalStateException): ResponseEntity<String> = ResponseEntity.badRequest().body(e.message)
}