package com.sgpttt.UtilsService.controller;

import com.sgpttt.UtilsService.dto.request.CreateChangeRequestDTO;
import com.sgpttt.UtilsService.dto.request.UpdateChangeRequestDTO;
import com.sgpttt.UtilsService.dto.response.ChangeRequestDTO;
import com.sgpttt.UtilsService.security.RequiresRole;
import com.sgpttt.UtilsService.service.ChangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/utils/change-request")
public class ChangeRequestController {
    private final ChangeRequestService changeRequestService;

    @Autowired
    public ChangeRequestController(ChangeRequestService changeRequestService) {
        this.changeRequestService = changeRequestService;
    }

    @PostMapping
    @RequiresRole({"Student", "Catt"})
    public ResponseEntity<ChangeRequestDTO> createChangeRequest(@ModelAttribute CreateChangeRequestDTO createChangeRequestDTO) {
        try{
            ChangeRequestDTO changeRequestDTO = changeRequestService.createChangeRequest(
                    createChangeRequestDTO.getFile().getBytes(),
                    createChangeRequestDTO.getRequestComments(),
                    createChangeRequestDTO.getProtocolId()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(changeRequestDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @PutMapping("/{id}")
    @RequiresRole({"Catt"})
    public ResponseEntity<ChangeRequestDTO> updateChangeRequest(@ModelAttribute UpdateChangeRequestDTO updateChangeRequestDTO) {
        try{
            ChangeRequestDTO changeRequestDTO = changeRequestService.changeRequestState(
                    updateChangeRequestDTO.getId(),
                    updateChangeRequestDTO.getState()
            );
            return ResponseEntity.status(HttpStatus.OK).body(changeRequestDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping("/{id}")
    @RequiresRole({"Student", "Catt"})
    public ResponseEntity<ChangeRequestDTO> getChangeRequest(@PathVariable String id) {
        try{
            ChangeRequestDTO changeRequestDTO = changeRequestService.getChangeRequest(Long.parseLong(id));
            return ResponseEntity.status(HttpStatus.OK).body(changeRequestDTO);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping("/")
    @RequiresRole({"Catt"})
    public ResponseEntity<List<ChangeRequestDTO>> getChangeRequests() {
        try{
            List<ChangeRequestDTO> changeRequestDTOs = changeRequestService.getChangeRequests();
            return ResponseEntity.status(HttpStatus.OK).body(changeRequestDTOs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @GetMapping("/protocol/{protocolId}")
    @RequiresRole({"Student", "Catt"})
    public ResponseEntity<List<ChangeRequestDTO>> getChangeRequestsByProtocolId(@PathVariable String protocolId) {
        try{
            List<ChangeRequestDTO> changeRequestDTOs = changeRequestService.getChangeRequestsByProtocolId(Long.parseLong(protocolId));
            return ResponseEntity.status(HttpStatus.OK).body(changeRequestDTOs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }
}
