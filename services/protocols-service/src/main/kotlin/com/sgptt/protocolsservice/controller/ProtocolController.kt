package com.sgptt.protocolsservice.controller

import com.sgptt.protocolsservice.model.ProtocolPage
import com.sgptt.protocolsservice.service.ProtocolService
import kotlinx.coroutines.coroutineScope
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/protocols")
class ProtocolController(private val service: ProtocolService) {
	
	@GetMapping("/all")
	suspend fun getPageOfProtocols(
		@RequestParam(defaultValue = "0") page: Int,
		@RequestParam(defaultValue = "3") size: Int
	): ResponseEntity<ProtocolPage> = coroutineScope {
		val pageable = PageRequest.of(page, size, Sort.by("uploadAt").descending())
		ResponseEntity(service.getPageOfProtocols(pageable), HttpStatus.OK)
	}
	
}