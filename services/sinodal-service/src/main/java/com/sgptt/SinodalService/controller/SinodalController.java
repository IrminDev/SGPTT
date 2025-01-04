package com.sgptt.SinodalService.controller;

import com.sgptt.SinodalService.dto.request.SinodalRequestDTO;
import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.security.RequiresRole;
import com.sgptt.SinodalService.service.SinodalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sinodal")
public class SinodalController {
    private final SinodalService sinodalService;

    @Autowired
    public SinodalController(SinodalService sinodalService) {
        this.sinodalService = sinodalService;
    }

    @PostMapping
    @RequiresRole({"Catt"})
    public ResponseEntity<SinodalDTO> createSinodal(@ModelAttribute SinodalRequestDTO sinodalRequestDTO) {
        try {
            SinodalDTO sinodalDTO = sinodalService.createSinodal(sinodalRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(sinodalDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    @RequiresRole({"Catt", "Professor", "Student"})
    public ResponseEntity<SinodalDTO> getSinodal(@RequestParam Long id) {
        try {
            SinodalDTO sinodalDTO = sinodalService.getSinodal(id);
            return ResponseEntity.status(HttpStatus.OK).body(sinodalDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/professor/{professorId}")
    @RequiresRole({"Catt", "Professor"})
    public ResponseEntity<List<SinodalDTO>> getSinodalsByProfessor(@RequestParam Long professorId) {
        try {
            List<SinodalDTO> sinodalDTOs = sinodalService.getSinodalsByProfessor(professorId);
            return ResponseEntity.status(HttpStatus.OK).body(sinodalDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/")
    @RequiresRole({"Catt"})
    public ResponseEntity<List<SinodalDTO>> getAllSinodals() {
        try {
            List<SinodalDTO> sinodalDTOs = sinodalService.getAllSinodals();
            return ResponseEntity.status(HttpStatus.OK).body(sinodalDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
