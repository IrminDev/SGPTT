package com.sgpttt.UtilsService.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgpttt.UtilsService.dto.response.ProfessorDTO;
import com.sgpttt.UtilsService.entity.Academy;
import com.sgpttt.UtilsService.entity.Professor;
import com.sgpttt.UtilsService.mapper.ProfessorMapper;
import com.sgpttt.UtilsService.repository.ProtocolRepository;
import com.sgpttt.UtilsService.repository.SinodalRepository;

@Service
public class SinodalSuggestionService {
    private final SinodalRepository sinodalRepository;

    private final ProtocolRepository protocolRepository;

    private final ProfessorMapper professorMapper;

    @Autowired
    public SinodalSuggestionService(SinodalRepository sinodalRepository, ProtocolRepository protocolRepository, ProfessorMapper professorMapper) {
        this.sinodalRepository = sinodalRepository;
        this.protocolRepository = protocolRepository;
        this.professorMapper = professorMapper;
    }
    
    /** 
     * This method search for professors that has the same area of expertise as the protocol and are available for the protocol (less than 5 protocols as sinodal)
     * @param Protocol the protocol that we want to suggest sinodals for
     * @return a list of professors that are available for the protocol
     */
    public List<ProfessorDTO> suggestSinodals(String id) {
        List<Professor> professors = sinodalRepository.findProfessorsWithLessThanFiveProtocols();

        List<Academy> academies = protocolRepository.findAcademyByProtocolId(Long.valueOf(id));

        // Parse the academies to a Set
        Set<Academy> academySet = new HashSet<>(academies);

        // Filter the professors that are in the same academy as the protocol
        professors = professors.stream().filter(professor -> academySet.contains(professor.getAcademy())).toList();

        return professorMapper.professorsToProfessorDTOs(professors);
    }
}
