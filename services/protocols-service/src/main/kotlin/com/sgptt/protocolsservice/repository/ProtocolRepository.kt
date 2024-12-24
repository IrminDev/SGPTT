package com.sgptt.protocolsservice.repository

import org.springframework.data.repository.PagingAndSortingRepository
import com.sgptt.protocolsservice.repository.entity.Protocol

interface ProtocolRepository : PagingAndSortingRepository<Protocol, Long>