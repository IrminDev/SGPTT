package com.sgpttt.UtilsService.controller;

import com.sgpttt.UtilsService.dto.request.CreateChangeRequestDTO;
import com.sgpttt.UtilsService.dto.request.UpdateChangeRequestDTO;
import com.sgpttt.UtilsService.dto.response.ChangeRequestDTO;
import com.sgpttt.UtilsService.security.RequiresRole;
import com.sgpttt.UtilsService.service.ChangeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/utils/change-request")
public class ChangeRequestController {
    private final ChangeRequestService changeRequestService;

    @Autowired
    public ChangeRequestController(ChangeRequestService changeRequestService) {
        this.changeRequestService = changeRequestService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @RequiresRole({"Student", "Catt"})
    public ResponseEntity<ChangeRequestDTO> createChangeRequest(@RequestPart("data") CreateChangeRequestDTO createChangeRequestDTO,
                                                                @RequestPart("file") MultipartFile file) {
        try{
            ChangeRequestDTO changeRequestDTO = changeRequestService.createChangeRequest(
                    file.getBytes(),
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
    public ResponseEntity<ChangeRequestDTO> updateChangeRequest(@RequestBody UpdateChangeRequestDTO updateChangeRequestDTO) {
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
