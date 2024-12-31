package com.sgptt.protocolsservice.controller

import com.sgptt.protocolsservice.extension.buildErrorMessage
import com.sgptt.protocolsservice.model.ProtocolPage
import com.sgptt.protocolsservice.model.dto.ProtocolDTO
import com.sgptt.protocolsservice.model.request.UpdateProtocolRequest
import com.sgptt.protocolsservice.model.request.UploadProtocolRequest
import com.sgptt.protocolsservice.model.response.UploadProtocolResponse
import com.sgptt.protocolsservice.security.RequiresRole
import com.sgptt.protocolsservice.service.ProtocolService
import jakarta.validation.Valid
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/protocols")
class ProtocolController(private val service: ProtocolService) {
	
	@GetMapping("/all")
	@RequiresRole(roles = ["Catt"])
	fun getPageOfProtocols(
		@RequestParam(defaultValue = "0") page: Int,
		@RequestParam(defaultValue = "5") size: Int,
	): ResponseEntity<ProtocolPage> {
		val pageable = PageRequest.of(page, size, Sort.by("createdAt").descending())
		return ResponseEntity(service.getPageOfProtocols(pageable), HttpStatus.OK)
	}
	
	@GetMapping("/get")
	@RequiresRole(roles = ["Catt", "Student", "Professor"])
	fun getProtocolById(
		@RequestParam("protocolId", required = false) id: Long?,
		@RequestParam("studentId", required = false) studentId: Long?,
		@RequestParam("professorId", required = false) professorId: Long?
	): List<ProtocolDTO> {
		id?.let { return listOf(service.findById(it)) }
		professorId?.let { return service.findAllByProfessorId(it) }
		studentId?.let { return service.findAllByStudentId(it) }
		return emptyList()
	}
	
	@PutMapping("/update")
	@RequiresRole(roles = ["Catt"])
	fun updateProtocol(
		@RequestParam(required = true) protocolId: Long,
		@RequestPart("file", required = false) file: MultipartFile?,
		@RequestPart("updateRequest") uploadRequest: UpdateProtocolRequest,
		result: BindingResult
	): ResponseEntity<UploadProtocolResponse> {
		if (result.hasFieldErrors()) {
			return ResponseEntity(UploadProtocolResponse.FieldError(result.buildErrorMessage()), HttpStatus.BAD_REQUEST)
		}
		val (title, keywords, abstract, workMates, directors) = uploadRequest
		val updated = service.updateProtocol(protocolId, file, title, keywords, abstract, workMates, directors)
		return ResponseEntity(UploadProtocolResponse.UploadSuccess(updated), HttpStatus.CREATED)
	}
	
	@PutMapping(
		"/upload",
		consumes = [MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_PDF_VALUE],
		produces = [MediaType.APPLICATION_JSON_VALUE]
	)
	@RequiresRole(roles = ["Student"])
	fun uploadProtocol(
		@RequestPart("file") file: MultipartFile,
		@Valid @RequestPart("uploadRequest") uploadRequest: UploadProtocolRequest,
		result: BindingResult,
	): ResponseEntity<UploadProtocolResponse> {
		/*
		* Example response if the request has errors
		* {
		*   "message" : "protocolTitle: 'Cannot be blank',
		*                abstract: 'Cannot be blank'"
		* }
		* */
		if (result.hasFieldErrors()) {
			return ResponseEntity(UploadProtocolResponse.FieldError(result.buildErrorMessage()), HttpStatus.BAD_REQUEST)
		}
		if (file.contentType != MediaType.APPLICATION_PDF_VALUE) return ResponseEntity(
			UploadProtocolResponse.BadFileType,
			HttpStatus.UNSUPPORTED_MEDIA_TYPE
		)
		if (file.isEmpty) return ResponseEntity(UploadProtocolResponse.EmptyFile, HttpStatus.LENGTH_REQUIRED)
		val (id, title, keywords, abstract, workmates, directors) = uploadRequest
		val new = service.registryProtocol(file, id, title, keywords, abstract, workmates, directors)
		return ResponseEntity(UploadProtocolResponse.UploadSuccess(new), HttpStatus.CREATED)
		
	}
}
