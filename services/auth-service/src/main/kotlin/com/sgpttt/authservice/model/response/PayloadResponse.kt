package com.sgpttt.authservice.model.response

data class PayloadResponse(
	val isAuthorized: Boolean,
	val personId: Long,
)
