package com.sgpttt.UtilsService.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.MoreLikeThisQuery;
import org.springframework.stereotype.Service;

import com.sgpttt.UtilsService.entity.ProtocolDocument;

@Service
public class ProtocolDocumentService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public List<ProtocolDocument> findSimilarDocuments(String id) {
        MoreLikeThisQuery moreLikeThisQuery = new MoreLikeThisQuery();
        moreLikeThisQuery.setId(id);
        moreLikeThisQuery.addFields("title", "keywords", "abstratcText");
        moreLikeThisQuery.setMinDocFreq(1);
        moreLikeThisQuery.setMinTermFreq(1);

        SearchHits<ProtocolDocument> searchHits = elasticsearchOperations.search(moreLikeThisQuery, ProtocolDocument.class);
        return searchHits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
    }
}