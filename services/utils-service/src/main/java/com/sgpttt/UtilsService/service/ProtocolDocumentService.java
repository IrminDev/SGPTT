package com.sgpttt.UtilsService.service;

import com.sgpttt.UtilsService.dto.response.ProtocolDocumentDTO;
import com.sgpttt.UtilsService.entity.ProtocolDocument;
import com.sgpttt.UtilsService.mapper.ProtocolDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.MoreLikeThisQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProtocolDocumentService {
    private final ElasticsearchOperations elasticsearchOperations;
    private final ProtocolDocumentMapper protocolDocumentMapper;

    @Autowired
    public ProtocolDocumentService(ElasticsearchOperations elasticsearchOperations, ProtocolDocumentMapper protocolDocumentMapper) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.protocolDocumentMapper = protocolDocumentMapper;
    }

    public List<ProtocolDocumentDTO> findSimilarDocuments(String id) {
        MoreLikeThisQuery moreLikeThisQuery = new MoreLikeThisQuery();
        moreLikeThisQuery.setId(id);
        moreLikeThisQuery.addFields("title", "keywords", "protocolAbstract");
        moreLikeThisQuery.setMinDocFreq(1);
        moreLikeThisQuery.setMinTermFreq(1);
        moreLikeThisQuery.setMaxQueryTerms(10);

        SearchHits<ProtocolDocument> searchHits = elasticsearchOperations.search(moreLikeThisQuery, ProtocolDocument.class);

        return searchHits.getSearchHits().stream().map(hit -> {
            ProtocolDocumentDTO dto = protocolDocumentMapper.protocolDocumentToProtocolDocumentDTO(hit.getContent());
            dto.setScore(hit.getScore()); // Set the score
            return dto;
        }).collect(Collectors.toList());
    }
}