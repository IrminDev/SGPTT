package com.sgptt.protocolsservice.interceptor.model

data class PayloadResponse(
	val isAuthorized: Boolean,
	val personId: Long,
)
