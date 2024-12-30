package com.sgpttt.UtilsService.service;

import com.sgpttt.UtilsService.dto.response.ProfessorDTO;
import com.sgpttt.UtilsService.entity.Professor;
import com.sgpttt.UtilsService.entity.Protocol;
import com.sgpttt.UtilsService.mapper.ProfessorMapper;
import com.sgpttt.UtilsService.repository.ProfessorRepository;
import com.sgpttt.UtilsService.repository.ProtocolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinodalSuggestionService {
    private final ProfessorMapper professorMapper;

    private final ProtocolRepository protocolRepository;

    private final ProfessorRepository professorRepository;

    @Autowired
    public SinodalSuggestionService(ProfessorMapper professorMapper, ProtocolRepository protocolRepository, ProfessorRepository professorRepository) {
        this.professorMapper = professorMapper;
        this.protocolRepository = protocolRepository;
        this.professorRepository = professorRepository;
    }

    /** 
     * This method search for professors that has the same area of expertise as the protocol and are available for the protocol (less than 5 protocols as sinodal)
     * @param id the protocol that we want to suggest synodals for
     * @return a list of professors that are available for the protocol
     */
    public List<ProfessorDTO> suggestSinodals(String id) {
        List<Professor> professors = professorRepository.findProfessorsWithLessThanFiveProtocols();
        Protocol protocol = protocolRepository.findById(Long.parseLong(id)).orElseThrow(() -> new IllegalArgumentException("Protocol not found"));

        List<Professor> filteredProfessors = professors.stream().filter(professor -> protocol.getAcademies().contains(professor.getAcademy())).toList();

        return professorMapper.professorsToProfessorDTOs(filteredProfessors);

    }
}
