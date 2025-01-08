package com.sgptt.SinodalService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgptt.SinodalService.dto.request.SinodalRequestDTO;
import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.entity.Professor;
import com.sgptt.SinodalService.entity.Protocol;
import com.sgptt.SinodalService.entity.Sinodal;
import com.sgptt.SinodalService.mapper.SinodalMapper;
import com.sgptt.SinodalService.model.State;
import com.sgptt.SinodalService.repository.ProfessorRepository;
import com.sgptt.SinodalService.repository.ProtocolRepository;
import com.sgptt.SinodalService.repository.SinodalRepository;

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
                Protocol protocolEntity = protocol.get();
                if(protocolEntity.getSinodals().size() == 3){
                    protocolEntity.setState(State.EVALUATING);
                    protocolRepository.save(protocol.get());
                }

                return sinodalMapper.sinodalToSinodalDTO(sinodal);
            } else {
                throw new IllegalArgumentException("Protocol not found");
            }
        } else {
            throw new IllegalArgumentException("Professor not found");
        }
    }

    public SinodalDTO createSinodalByProfessor(SinodalRequestDTO sinodalRequestDTO) {
        Sinodal sinodal = new Sinodal();
        Optional<Professor> professor = professorRepository.findById(sinodalRequestDTO.getProfessorId());
        if(professor.isPresent()){
            if(professor.get().getSinodals().size() >= 5){
                throw new IllegalArgumentException("Professor already has 5 sinodals");
            } else {
                sinodal.setProfessor(professor.get());
                Optional<Protocol> protocol = protocolRepository.findById(sinodalRequestDTO.getProtocolId());
                if(protocol.isPresent()){
                    sinodal.setProtocol(protocol.get());
                    sinodalRepository.save(sinodal);
                    Protocol protocolEntity = protocol.get();
                    if(protocolEntity.getSinodals().size() == 3){
                        protocolEntity.setState(State.EVALUATING);
                        protocolRepository.save(protocol.get());
                    }

                    return sinodalMapper.sinodalToSinodalDTO(sinodal);
                } else {
                    throw new IllegalArgumentException("Protocol not found");
                }
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

    public List<SinodalDTO> getSinodalsByProtocol(Long protocolId) {
        return sinodalMapper.sinodalToSinodalDTO(sinodalRepository.findByProtocol_ProtocolId(protocolId));
    }
}
