package com.sgptt.protocolsservice.model.exception

abstract class EntityNotFoundException(override val message: String) : RuntimeException(message)