package com.sgptt.protocolsservice.service

import com.sgptt.protocolsservice.entension.toDomain
import com.sgptt.protocolsservice.model.ProtocolPage
import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.repository.ProtocolRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProtocolService(private val repository: ProtocolRepository) {
	
	fun getPageOfProtocols(pageable: Pageable): ProtocolPage {
		val page = repository.findAll(pageable)
		return ProtocolPage(
			totalPages = page.totalPages,
			totalItems = page.totalElements,
			currentPage = page.number,
			protocols = page.content.map { it.toDomain() }
		)
	}
	
	fun findById(id: Long): ProtocolDTO = repository.findById(id).toDomain(withFile = true)
	
}