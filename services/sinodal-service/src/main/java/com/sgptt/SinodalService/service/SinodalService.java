package com.sgptt.SinodalService.service;

import com.sgptt.SinodalService.dto.request.SinodalRequestDTO;
import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.entity.Sinodal;
import com.sgptt.SinodalService.mapper.SinodalMapper;
import com.sgptt.SinodalService.repository.ProfessorRepository;
import com.sgptt.SinodalService.repository.ProtocolRepository;
import com.sgptt.SinodalService.repository.SinodalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinodalService {
    private final ProfessorRepository professorRepository;
    private final SinodalRepository sinodalRepository;
    private final ProtocolRepository protocolRepository;
    private final SinodalMapper sinodalMapper;

    @Autowired
    public SinodalService(ProfessorRepository professorRepository, SinodalRepository sinodalRepository, ProtocolRepository protocolRepository, SinodalMapper sinodalMapper) {
        this.professorRepository = professorRepository;
        this.sinodalRepository = sinodalRepository;
        this.protocolRepository = protocolRepository;
        this.sinodalMapper = sinodalMapper;
    }

    public SinodalDTO createSinodal(SinodalRequestDTO sinodalRequestDTO) {
        Sinodal sinodal = new Sinodal();
        sinodal.setProfessor(professorRepository.findById(sinodalRequestDTO.getProfessorId()).get());
        sinodal.setProtocol(protocolRepository.findById(sinodalRequestDTO.getProtocolId()).get());
        sinodalRepository.save(sinodal);

        return sinodalMapper.sinodalToSinodalDTO(sinodal);
    }

    public SinodalDTO getSinodal(Long id) {
        return sinodalMapper.sinodalToSinodalDTO(sinodalRepository.findById(id).get());
    }

    public List<SinodalDTO> getAllSinodals() {
        return sinodalMapper.sinodalToSinodalDTO(sinodalRepository.findAll());
    }

    public List<SinodalDTO> getSinodalsByProfessor(Long professorId) {
        return sinodalMapper.sinodalToSinodalDTO(sinodalRepository.findByProfessor_PersonId(professorId));
    }
}
