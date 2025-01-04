package com.sgptt.protocolsservice.repository

import com.sgptt.protocolsservice.repository.entity.ProtocolDocument
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface ProtocolSearchRepository : ElasticsearchRepository<ProtocolDocument, Long>
