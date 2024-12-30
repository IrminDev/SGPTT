package com.sgpttt.UtilsService.controller;

import com.sgpttt.UtilsService.dto.response.ProfessorDTO;
import com.sgpttt.UtilsService.security.RequiresRole;
import com.sgpttt.UtilsService.service.SinodalSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/utils/suggestions")
public class SinodalsSuggestionController {
    private final SinodalSuggestionService sinodalsSuggestionService;

    @Autowired
    public SinodalsSuggestionController(SinodalSuggestionService sinodalsSuggestionService) {
        this.sinodalsSuggestionService = sinodalsSuggestionService;
    }

    @GetMapping("/{id}")
    @RequiresRole({"Catt"})
    public ResponseEntity<List<ProfessorDTO>> suggestSinodals(@PathVariable String id) {
        try {
            List<ProfessorDTO> professors = sinodalsSuggestionService.suggestSinodals(id);
            return ResponseEntity.status(HttpStatus.OK).body(professors);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
