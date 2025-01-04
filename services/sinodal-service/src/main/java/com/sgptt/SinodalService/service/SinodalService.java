package com.sgptt.SinodalService.service;

import com.sgptt.SinodalService.dto.request.SinodalRequestDTO;
import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.entity.Professor;
import com.sgptt.SinodalService.entity.Protocol;
import com.sgptt.SinodalService.entity.Sinodal;
import com.sgptt.SinodalService.mapper.SinodalMapper;
import com.sgptt.SinodalService.repository.ProfessorRepository;
import com.sgptt.SinodalService.repository.ProtocolRepository;
import com.sgptt.SinodalService.repository.SinodalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Professor> professor = professorRepository.findById(sinodalRequestDTO.getProfessorId());
        if(professor.isPresent()){
            sinodal.setProfessor(professor.get());
            Optional<Protocol> protocol = protocolRepository.findById(sinodalRequestDTO.getProtocolId());
            if(protocol.isPresent()){
                sinodal.setProtocol(protocol.get());
                sinodalRepository.save(sinodal);
                return sinodalMapper.sinodalToSinodalDTO(sinodal);
            } else {
                throw new IllegalArgumentException("Protocol not found");
            }
        } else {
            throw new IllegalArgumentException("Professor not found");
        }
    }

    public SinodalDTO getSinodal(Long id) {
        Sinodal sinodal = sinodalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Sinodal not found"));
        return sinodalMapper.sinodalToSinodalDTO(sinodal);
    }

    public List<SinodalDTO> getAllSinodals() {
        return sinodalMapper.sinodalToSinodalDTO(sinodalRepository.findAll());
    }

    public List<SinodalDTO> getSinodalsByProfessor(Long professorId) {
        return sinodalMapper.sinodalToSinodalDTO(sinodalRepository.findByProfessor_PersonId(professorId));
    }
}
