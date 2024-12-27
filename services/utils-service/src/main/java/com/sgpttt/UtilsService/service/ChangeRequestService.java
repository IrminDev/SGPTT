package com.sgpttt.UtilsService.service;

import java.sql.Timestamp;
import java.util.List;

import com.sgpttt.UtilsService.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgpttt.UtilsService.dto.response.ChangeRequestDTO;
import com.sgpttt.UtilsService.entity.ChangeRequest;
import com.sgpttt.UtilsService.mapper.ChangeRequestMapper;
import com.sgpttt.UtilsService.repository.ChangeRequestRepository;
import com.sgpttt.UtilsService.repository.ProtocolRepository;

@Service
public class ChangeRequestService {
    
    @Autowired
    public ChangeRequestService(ChangeRequestRepository changeRequestRepository, ProtocolRepository protocolRepository, ChangeRequestMapper changeRequestMapper) {
        this.changeRequestRepository = changeRequestRepository;
        this.protocolRepository = protocolRepository;
        this.changeRequestMapper = changeRequestMapper;
    }

    private final ChangeRequestRepository changeRequestRepository;
    private final ProtocolRepository protocolRepository;
    private final ChangeRequestMapper changeRequestMapper;

    public ChangeRequestDTO createChangeRequest(byte[] formatData, String requestComments, Long protocolId) {
        // Create a new ChangeRequest
        ChangeRequest changeRequest = new ChangeRequest();
        changeRequest.setFormatData(formatData);
        changeRequest.setRequestComments(requestComments);
        changeRequest.setProtocol(protocolRepository.findById(protocolId).orElseThrow(() -> new RuntimeException("Protocol not found")));
        changeRequest.setState(State.PENDING);
        changeRequest.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        // Save the ChangeRequest
        changeRequestRepository.save(changeRequest);

        return changeRequestMapper.changeRequestToChangeRequestDTO(changeRequest);
    }

    public ChangeRequestDTO changeRequestState(Long requestId, State state) {
        // Find the ChangeRequest
        ChangeRequest changeRequest = changeRequestRepository.findById(requestId).orElseThrow(() -> new RuntimeException("ChangeRequest not found"));

        // Find the new state
        changeRequest.setState(state);

        // Save the ChangeRequest
        changeRequestRepository.save(changeRequest);

        return changeRequestMapper.changeRequestToChangeRequestDTO(changeRequest);
    }

    public List<ChangeRequestDTO> getChangeRequests() {
        return changeRequestMapper.changeRequestsToChangeRequestDTOs(changeRequestRepository.findAll());
    }
}
