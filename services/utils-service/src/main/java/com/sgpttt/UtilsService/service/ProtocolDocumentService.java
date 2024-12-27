package com.sgpttt.UtilsService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.MoreLikeThisQuery;
import org.springframework.stereotype.Service;

import com.sgpttt.UtilsService.dto.response.ProtocolDocumentDTO;
import com.sgpttt.UtilsService.entity.ProtocolDocument;
import com.sgpttt.UtilsService.mapper.ProtocolDocumentMapper;

@Service
public class ProtocolDocumentService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private ProtocolDocumentMapper protocolDocumentMapper;

    public List<ProtocolDocumentDTO> findSimilarDocuments(String id) {
        MoreLikeThisQuery moreLikeThisQuery = new MoreLikeThisQuery();
        moreLikeThisQuery.setId(id);
        moreLikeThisQuery.addFields("title", "keywords", "abstratcText");
        moreLikeThisQuery.setMinDocFreq(1);
        moreLikeThisQuery.setMinTermFreq(1);

        SearchHits<ProtocolDocument> searchHits = elasticsearchOperations.search(moreLikeThisQuery, ProtocolDocument.class);

        List<ProtocolDocument> protocolDocuments = searchHits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());

        return protocolDocumentMapper.protocolDocumentsToProtocolDTOs(protocolDocuments);
    }
}
