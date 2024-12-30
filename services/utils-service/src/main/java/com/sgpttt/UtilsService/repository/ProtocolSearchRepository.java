package com.sgpttt.UtilsService.repository;

import com.sgpttt.UtilsService.entity.ProtocolDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProtocolSearchRepository extends ElasticsearchRepository<ProtocolDocument, Long> {
    
}
