package com.sgpttt.UtilsService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpttt.UtilsService.entity.ProtocolDocument;
import com.sgpttt.UtilsService.service.ProtocolDocumentService;

@RestController
@RequestMapping("/api/utils")
public class ProtocolController {
    @Autowired
    private ProtocolDocumentService protocolDocumentService;

    @GetMapping("/similar/{id}")
    public List<ProtocolDocument> findSimilarDocuments(@PathVariable String id) {
        return protocolDocumentService.findSimilarDocuments(id);
    }
}
