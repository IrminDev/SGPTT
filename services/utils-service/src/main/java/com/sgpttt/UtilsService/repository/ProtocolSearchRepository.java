package com.sgpttt.UtilsService.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.sgpttt.UtilsService.entity.ProtocolDocument;

public interface ProtocolSearchRepository extends ElasticsearchRepository<ProtocolDocument, Long> {
    
}
