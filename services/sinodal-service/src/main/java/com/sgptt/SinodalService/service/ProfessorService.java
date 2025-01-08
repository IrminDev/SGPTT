package com.sgptt.SinodalService.service;

import com.sgptt.SinodalService.dto.response.ProfessorDTO;
import com.sgptt.SinodalService.mapper.ProfessorMapper;
import com.sgptt.SinodalService.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper) {
        this.professorRepository = professorRepository;
        this.professorMapper = professorMapper;
    }

    public List<ProfessorDTO> getProfessors() {
        return professorMapper.professorToProfessorDTO(professorRepository.findAll());
    }
}
