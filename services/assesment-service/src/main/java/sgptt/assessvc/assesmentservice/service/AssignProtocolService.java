package sgptt.assessvc.assesmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgptt.assessvc.assesmentservice.entity.Protocol;
import sgptt.assessvc.assesmentservice.repository.AcademyRepository;
import sgptt.assessvc.assesmentservice.repository.ProtocolRespository;
import sgptt.assessvc.assesmentservice.request.AssignProtocolRequest;

import java.util.HashSet;

@Service
public class AssignProtocolService {

    public final ProtocolRespository protocolRepository;
    public final AcademyRepository academyRepository;

    @Autowired
    public AssignProtocolService(ProtocolRespository protocolRepository, AcademyRepository academyRepository) {
        this.protocolRepository = protocolRepository;
        this.academyRepository = academyRepository;
    }

    public void assign(AssignProtocolRequest assignProtocolRequest) {
        Protocol protocol = protocolRepository.findById(assignProtocolRequest.getProtocolId()).orElseThrow(() -> new RuntimeException("Protocol not found"));

        protocol.setAcademies(new HashSet<>(academyRepository.findAllById(assignProtocolRequest.getAcademies())));

        protocolRepository.save(protocol);
    }
}
