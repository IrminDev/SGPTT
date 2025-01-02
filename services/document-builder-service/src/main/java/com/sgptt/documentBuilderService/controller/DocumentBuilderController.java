package com.sgptt.documentBuilderService.controller;

import com.sgptt.documentBuilderService.service.ChangeRequestDocumentService;
import com.sgptt.documentBuilderService.service.ProtocolDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document")
public class DocumentBuilderController {
    private final ChangeRequestDocumentService changeRequestDocumentService;
    private final ProtocolDocumentService protocolDocumentService;

    @Autowired
    public DocumentBuilderController(ChangeRequestDocumentService changeRequestDocumentService, ProtocolDocumentService protocolDocumentService) {
        this.changeRequestDocumentService = changeRequestDocumentService;
        this.protocolDocumentService = protocolDocumentService;
    }

    @GetMapping("/protocol/{id}")
    public ResponseEntity<byte[]> getProtocolDocument(@PathVariable Long id) {
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=protocol" + id +".pdf");
            headers.add("Content-Type", "application/pdf");
            return ResponseEntity.ok().headers(headers).body(protocolDocumentService.getProtocolDocument(id));
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/change-request/{id}")
    public ResponseEntity<byte[]> getChangeRequestDocument(@PathVariable Long id) {
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=change-request" + id +".pdf");
            headers.add("Content-Type", "application/pdf");
            return ResponseEntity.ok().headers(headers).body(changeRequestDocumentService.getChangeRequestDocument(id));
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
