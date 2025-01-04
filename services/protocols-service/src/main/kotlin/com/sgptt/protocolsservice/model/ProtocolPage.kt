package com.sgptt.protocolsservice.model

import com.sgptt.protocolsservice.model.dto.ProtocolDTO

data class ProtocolPage(
	val totalPages: Int,
	val totalItems: Long,
	val currentPage: Int,
	val protocols: List<ProtocolDTO>
)
