package com.sgptt.protocolsservice.model.exception.handler

import com.sgptt.protocolsservice.model.exception.WrongUploadDateException
import com.sgptt.protocolsservice.model.response.UploadProtocolResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class WrongDateHandler : ControllerExceptionHandler<WrongUploadDateException, UploadProtocolResponse.WrongUploadDateResponse> {
	
	@ExceptionHandler(WrongUploadDateException::class)
	override fun handle(e: WrongUploadDateException): ResponseEntity<UploadProtocolResponse.WrongUploadDateResponse> {
		return ResponseEntity(UploadProtocolResponse.WrongUploadDateResponse(e), HttpStatus.SERVICE_UNAVAILABLE)
	}
}