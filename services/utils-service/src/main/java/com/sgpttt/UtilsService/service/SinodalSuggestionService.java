package com.sgpttt.UtilsService.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgpttt.UtilsService.entity.Academy;
import com.sgpttt.UtilsService.entity.Professor;
import com.sgpttt.UtilsService.repository.ProtocolRepository;
import com.sgpttt.UtilsService.repository.SinodalRepository;

@Service
public class SinodalSuggestionService {
    private final SinodalRepository sinodalRepository;

    private final ProtocolRepository protocolRepository;

    @Autowired
    public SinodalSuggestionService(SinodalRepository sinodalRepository, ProtocolRepository protocolRepository) {
        this.sinodalRepository = sinodalRepository;
        this.protocolRepository = protocolRepository;
    }
    
    /** 
     * This method search for professors that has the same area of expertise as the protocol and are available for the protocol (less than 5 protocols as sinodal)
     * @param Protocol the protocol that we want to suggest sinodals for
     * @return a list of professors that are available for the protocol
     */
    public List<Professor> suggestSinodals(String id) {
        List<Professor> professors = sinodalRepository.findProfessorsWithLessThanFiveProtocols();

        List<Academy> academies = protocolRepository.findAcademyByProtocolId(Long.valueOf(id));

        // Parse the academies to a Set
        Set<Academy> academySet = new HashSet<>(academies);

        // Filter professors that are not in the same area of expertise as the protocol
        return professors.stream()
            .filter(professor -> academySet.contains(professor.getAcademy()))
            .toList();
    }

}
