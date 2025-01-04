package com.sgptt.documentBuilderService.service;

import com.sgptt.documentBuilderService.entity.ChangeRequest;
import com.sgptt.documentBuilderService.repository.ChangeRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChangeRequestDocumentService {
    private final ChangeRequestRepository changeRequestRepository;

    @Autowired
    public ChangeRequestDocumentService(ChangeRequestRepository changeRequestRepository) {
        this.changeRequestRepository = changeRequestRepository;
    }

    public byte[] getChangeRequestDocument(Long changeRequestId) {
        byte[] changeRequest = changeRequestRepository.getFormatDataByRequestId(changeRequestId);
        if (changeRequest != null) {
            return changeRequest;
        } else {
            throw new IllegalArgumentException("ChangeRequest not found");
        }
    }
}
