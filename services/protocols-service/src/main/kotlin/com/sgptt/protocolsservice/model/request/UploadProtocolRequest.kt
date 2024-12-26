package com.sgptt.protocolsservice.model.request

data class UploadProtocolRequest(
	val protocolTitle: String,
	val keywords: List<String>,
	val abstract: String,
	val workMates: List<String>,
	val directors: List<String>
)
