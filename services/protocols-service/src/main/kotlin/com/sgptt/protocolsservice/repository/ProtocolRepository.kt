package com.sgptt.protocolsservice.repository

import com.sgptt.protocolsservice.repository.entity.Protocol
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository

interface ProtocolRepository : PagingAndSortingRepository<Protocol, Long>, JpaRepository<Protocol, Long>