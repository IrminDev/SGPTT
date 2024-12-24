package com.sgptt.protocolsservice.model

data class ProtocolPage(
	val totalPages: Int,
	val totalItems: Long,
	val currentPage: Int,
	val protocols: List<ProtocolDTO>
)
