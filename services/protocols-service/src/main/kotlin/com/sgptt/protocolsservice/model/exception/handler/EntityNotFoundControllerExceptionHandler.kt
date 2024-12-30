package com.sgptt.protocolsservice.model.exception.handler

import com.sgptt.protocolsservice.model.exception.EntityNotFoundException
import com.sgptt.protocolsservice.model.response.UploadProtocolResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class EntityNotFoundControllerExceptionHandler :
	ControllerExceptionHandler<EntityNotFoundException, UploadProtocolResponse.PersonNotFound> {
	
	@ExceptionHandler(EntityNotFoundException::class)
	override fun handle(e: EntityNotFoundException): ResponseEntity<UploadProtocolResponse.PersonNotFound> {
		return ResponseEntity(UploadProtocolResponse.PersonNotFound(e), HttpStatus.NOT_FOUND)
	}
}