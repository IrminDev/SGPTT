package com.sgptt.protocolsservice.service

import com.sgptt.protocolsservice.entension.toDomain
import com.sgptt.protocolsservice.model.ProtocolDTO
import com.sgptt.protocolsservice.model.ProtocolPage
import com.sgptt.protocolsservice.repository.ProtocolRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProtocolService(private val repository: ProtocolRepository) {
	
	suspend fun getPageOfProtocols(pageable: Pageable): ProtocolPage = withContext(Dispatchers.IO) {
		val page = repository.findAll(pageable)
		val protocols: Array<Deferred<ProtocolDTO>> = Array(size = page.content.size) { index ->
			async { page.content[index].toDomain() }
		}
		return@withContext ProtocolPage(
			totalPages = page.totalPages,
			totalItems = page.totalElements,
			currentPage = page.number,
			protocols = awaitAll(*protocols)
		)
	}
	
}