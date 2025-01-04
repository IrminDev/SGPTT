package com.sgptt.protocolsservice.model.exception.handler

import org.springframework.http.ResponseEntity

interface ControllerExceptionHandler<in E: Exception, T> {
	
	fun handle(e: E): ResponseEntity<T>
	
}