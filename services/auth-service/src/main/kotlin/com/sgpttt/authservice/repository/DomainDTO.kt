package com.sgpttt.authservice.repository

interface DomainDTO<T> {
	fun toDomain(): T
}