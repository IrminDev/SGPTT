package com.sgptt.protocolsservice.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "protocol")
data class ProtocolDocument(
	@Id
	var id: Long? = null,
	@Field(type = FieldType.Text)
	val title: String,
	
	@Field(type = FieldType.Text)
	val keywords: String,
	
	@Field(type = FieldType.Text)
	val protocolAbstract: String
)
