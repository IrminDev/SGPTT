package com.sgpttt.UtilsService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgpttt.UtilsService.dto.response.ProfessorDTO;
import com.sgpttt.UtilsService.service.SinodalSuggestionService;

@RestController
@RequestMapping("/api/utils/suggestions")
public class SinodalsSuggestionController {
    
    private final SinodalSuggestionService sinodalsSuggestionService;

    @Autowired
    public SinodalsSuggestionController(SinodalSuggestionService sinodalsSuggestionService) {
        this.sinodalsSuggestionService = sinodalsSuggestionService;
    }

    @GetMapping("/{id}")
    public List<ProfessorDTO> suggestSinodals(@PathVariable String id) {
        return sinodalsSuggestionService.suggestSinodals(id);
    }
}
