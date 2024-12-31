package com.sgptt.protocolsservice.model.dto

import com.sgptt.protocolsservice.model.State
import com.sgptt.protocolsservice.repository.entity.Protocol
import java.sql.Timestamp
import java.time.LocalDateTime

object EmptyProtocol : Protocol(
	id = 0L,
	title = "",
	keywords = "",
	protocolAbstract = "",
	fileData = byteArrayOf(),
	state = State.FINISHED,
	createdAt = Timestamp.valueOf(LocalDateTime.now()),
	academies = emptySet(),
	students = mutableSetOf(),
	directors = mutableSetOf(),
	sinodals = emptySet()
)