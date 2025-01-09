package com.sgptt.protocolsservice.model.exception.handler

import com.sgptt.protocolsservice.model.exception.StudentAlreadyHasActiveProtocolException
import com.sgptt.protocolsservice.model.response.UploadProtocolResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class StudentHasActiveProtocolHandler :
	ControllerExceptionHandler<StudentAlreadyHasActiveProtocolException, UploadProtocolResponse.StudentAlreadyHasActiveProtocolResponse> {
	
	@ExceptionHandler(StudentAlreadyHasActiveProtocolException::class)
	override fun handle(e: StudentAlreadyHasActiveProtocolException): ResponseEntity<UploadProtocolResponse.StudentAlreadyHasActiveProtocolResponse> {
		return ResponseEntity(UploadProtocolResponse.StudentAlreadyHasActiveProtocolResponse(e), HttpStatus.CONFLICT)
	}
	
}