package com.sgptt.protocolsservice.model.exception.handler

import com.sgptt.protocolsservice.model.Career
import com.sgptt.protocolsservice.model.exception.DifferentCareerException
import com.sgptt.protocolsservice.model.response.UploadProtocolResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class DifferentCareerHandler :
	ControllerExceptionHandler<DifferentCareerException, UploadProtocolResponse.NotSameCareerResponse> {
	
	@ExceptionHandler(DifferentCareerException::class)
	override fun handle(e: DifferentCareerException): ResponseEntity<UploadProtocolResponse.NotSameCareerResponse> {
		val students = e.message.removePrefix("{").removeSuffix("}").split(",")
		val map = students.associate {
			val split = it.split("=")
			split[0] to Career.valueOf(split[1])
		}
		val message = "These students are not in the same career"
		return ResponseEntity.badRequest().body(UploadProtocolResponse.NotSameCareerResponse(message, map))
	}
	
}