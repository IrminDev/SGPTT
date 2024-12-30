package com.sgptt.protocolsservice.model.request

import com.sgptt.protocolsservice.validation.AllEnrollment
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size

data class UploadProtocolRequest(
	
	@field:Positive
	val studentId: Long,
	
	@field:NotBlank
	@field:Size(min = 8, max = 50)
	val protocolTitle: String,
	
	@field:Size(min = 1, max = 100)
	val keywords: List<@NotBlank String>,
	
	@field:NotBlank
	val abstract: String,
	
	@field:Size(max = 4)
	@AllEnrollment
	val workMates: List<String>, //student numbers
	
	@field:Size(min = 1, max = 3)
	@AllEnrollment
	val directors: List<String>  //Professor number
)
