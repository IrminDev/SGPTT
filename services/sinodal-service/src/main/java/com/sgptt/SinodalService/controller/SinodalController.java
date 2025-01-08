package com.sgptt.SinodalService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgptt.SinodalService.dto.request.SinodalRequestDTO;
import com.sgptt.SinodalService.dto.response.ProfessorDTO;
import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.security.RequiresRole;
import com.sgptt.SinodalService.service.ProfessorService;
import com.sgptt.SinodalService.service.SinodalService;

@RestController
@RequestMapping("/api/sinodal")
public class SinodalController {
    private final SinodalService sinodalService;
    private final ProfessorService professorService;

    @Autowired
    public SinodalController(SinodalService sinodalService, ProfessorService professorService) {
        this.sinodalService = sinodalService;
        this.professorService = professorService;
    }

    @PostMapping
    @RequiresRole({"Catt"})
    public ResponseEntity<SinodalDTO> createSinodal(@RequestBody SinodalRequestDTO sinodalRequestDTO) {
        try {
            SinodalDTO sinodalDTO = sinodalService.createSinodal(sinodalRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(sinodalDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/professor")
    @RequiresRole({"Professor"})
    public ResponseEntity<SinodalDTO> createSinodalByProfessor(@RequestBody SinodalRequestDTO sinodalRequestDTO) {
        try {
            SinodalDTO sinodalDTO = sinodalService.createSinodalByProfessor(sinodalRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(sinodalDTO);
        } catch (Exception e) {
            e.printStackTrace();

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
            System.out.println(e);
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
            System.out.println(e);
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
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/protocol/{protocolId}")
    @RequiresRole({"Catt", "Professor", "Student"})
    public ResponseEntity<List<SinodalDTO>> getSinodalsByProtocol(@RequestParam Long protocolId) {
        try {
            List<SinodalDTO> sinodalDTOs = sinodalService.getSinodalsByProtocol(protocolId);
            return ResponseEntity.status(HttpStatus.OK).body(sinodalDTOs);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/professors/all")
    @RequiresRole({"Catt", "Professor"})
    public ResponseEntity<List<ProfessorDTO>> getAllProfessors() {
        try {
            List<ProfessorDTO> professorDTOs = professorService.getProfessors();
            return ResponseEntity.status(HttpStatus.OK).body(professorDTOs);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
