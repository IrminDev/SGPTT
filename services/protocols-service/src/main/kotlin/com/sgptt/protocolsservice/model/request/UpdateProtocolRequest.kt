package com.sgptt.protocolsservice.model.request

import com.sgptt.protocolsservice.validation.AllEnrollment
import jakarta.validation.constraints.Size

data class UpdateProtocolRequest(
	@field:Size(min = 8, max = 50)
	val title: String?,
	@field:Size(min = 1, max = 100)
	val keywords: List<String>?,
	
	val abstract: String?,
	
	@AllEnrollment
	val workMates: List<String>?,
	
	@AllEnrollment
	val directors: List<String>?
)