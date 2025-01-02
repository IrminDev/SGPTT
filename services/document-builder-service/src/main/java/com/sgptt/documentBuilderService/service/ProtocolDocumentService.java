package com.sgptt.documentBuilderService.service;

import com.sgptt.documentBuilderService.entity.Protocol;
import com.sgptt.documentBuilderService.repository.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProtocolDocumentService {
    private final ProtocolRepository protocolRepository;

    @Autowired
    public ProtocolDocumentService(ProtocolRepository protocolRepository) {
        this.protocolRepository = protocolRepository;
    }

    public byte[] getProtocolDocument(Long protocolId) {
        byte[] protocol = protocolRepository.getFileDataByProtocolId(protocolId);
        if (protocol != null) {
            return protocol;
        } else {
            throw new IllegalArgumentException("Protocol not found");
        }
    }
}
