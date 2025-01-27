package com.sgpttt.UtilsService.controller;

import com.sgpttt.UtilsService.dto.response.ProtocolDocumentDTO;
import com.sgpttt.UtilsService.security.RequiresRole;
import com.sgpttt.UtilsService.service.ProtocolDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/utils")
public class ProtocolController {
    private final ProtocolDocumentService protocolDocumentService;

    @Autowired
    public ProtocolController(ProtocolDocumentService protocolDocumentService) {
        this.protocolDocumentService = protocolDocumentService;
    }

    @GetMapping("/similar/{id}")
    @RequiresRole({"Catt"})
    public ResponseEntity<List<ProtocolDocumentDTO>> findSimilarDocuments(@PathVariable String id) {
        try {
            List<ProtocolDocumentDTO> protocols = protocolDocumentService.findSimilarDocuments(id);
            return ResponseEntity.status(HttpStatus.OK).body(protocols);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
