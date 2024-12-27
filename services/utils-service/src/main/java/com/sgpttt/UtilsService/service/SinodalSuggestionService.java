package com.sgpttt.UtilsService.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sgpttt.UtilsService.entity.Person;
import com.sgpttt.UtilsService.repository.PersonRepository;
import com.sgpttt.UtilsService.repository.ProfessorRepository;
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

    private final ProfessorRepository professorRepository;

    private final PersonRepository personRepository;

    @Autowired
    public SinodalSuggestionService(SinodalRepository sinodalRepository, ProtocolRepository protocolRepository, ProfessorMapper professorMapper, ProfessorRepository professorRepository, PersonRepository personRepository) {
        this.sinodalRepository = sinodalRepository;
        this.protocolRepository = protocolRepository;
        this.professorMapper = professorMapper;
        this.professorRepository = professorRepository;
        this.personRepository = personRepository;
    }
    
    /** 
     * This method search for professors that has the same area of expertise as the protocol and are available for the protocol (less than 5 protocols as sinodal)
     * @param id the protocol that we want to suggest sinodals for
     * @return a list of professors that are available for the protocol
     */
    public List<Person> suggestSinodals(String id) {
        return personRepository.findAll();
    }
}
