package com.sgptt.protocolsservice.controller

import com.sgptt.protocolsservice.model.ProtocolPage
import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.request.UploadProtocolRequest
import com.sgptt.protocolsservice.service.ProtocolService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/protocols")
class ProtocolController(private val service: ProtocolService) {
	
	@GetMapping("/all")
	fun getPageOfProtocols(
		@RequestParam(defaultValue = "0") page: Int,
		@RequestParam(defaultValue = "5") size: Int
	): ResponseEntity<ProtocolPage> {
		val pageable = PageRequest.of(page, size, Sort.by("uploadAt").descending())
		return ResponseEntity(service.getPageOfProtocols(pageable), HttpStatus.OK)
	}
	
	@GetMapping("/{id}")
	fun getProtocolById(@PathVariable id: Long): ProtocolDTO {
		return service.findById(id)
	}
	
	@PostMapping("/upload")
	fun uploadProtocol(@RequestBody file: MultipartFile, @RequestBody uploadRequest: UploadProtocolRequest) {}
	
}