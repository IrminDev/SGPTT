package com.sgpttt.UtilsService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpttt.UtilsService.dto.response.ProfessorDTO;
import com.sgpttt.UtilsService.service.SinodalSuggestionService;

@RestController
@RequestMapping("/api/utils/suggestions")
public class SinodalsSuggestionController {
    @Autowired
    private SinodalSuggestionService sinodalsSuggestionService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ProfessorDTO>> suggestSinodals(@PathVariable String id) {
        try {
            List<ProfessorDTO> professors = sinodalsSuggestionService.suggestSinodals(id);
            return ResponseEntity.status(HttpStatus.OK).body(professors);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
