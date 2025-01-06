package sgptt.assessvc.assesmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgptt.assessvc.assesmentservice.entity.Sinodal;
import sgptt.assessvc.assesmentservice.mapper.EvaluationMapper;
import sgptt.assessvc.assesmentservice.repository.CriterionEvaluationRepository;
import sgptt.assessvc.assesmentservice.repository.EvaluationRespository;
import sgptt.assessvc.assesmentservice.repository.ProfessorRepository;
import sgptt.assessvc.assesmentservice.repository.ProtocolRespository;
import sgptt.assessvc.assesmentservice.repository.SinodalRepository;
import sgptt.assessvc.assesmentservice.request.ProtocolAssessmentRequest;

@Service
public class ProtocolAssessmentService {

    public final CriterionEvaluationRepository criterionEvaluationRepository;
    public final EvaluationRespository evaluationRespository;
    public final ProfessorRepository professorRepository;
    public final SinodalRepository sinodalRepository;
    public final ProtocolRespository protocolRepository;

    @Autowired
    public ProtocolAssessmentService(EvaluationRespository evaluationRespository, CriterionEvaluationRepository criterionEvaluationRepository, SinodalRepository sinodalRepository, ProfessorRepository professorRepository, ProtocolRespository protocolRepository) {
        this.criterionEvaluationRepository = criterionEvaluationRepository;
        this.evaluationRespository = evaluationRespository;
        this.professorRepository = professorRepository;
        this.sinodalRepository = sinodalRepository;
        this.protocolRepository = protocolRepository;
    }

    public void evaluate(ProtocolAssessmentRequest protocolAssessmentRequest) {
        Sinodal sinodal = sinodalRepository.findByProfessorAndProtocol(professorRepository.findById(protocolAssessmentRequest.getEvaluationDTO().getProfessorId()).orElseThrow(() -> new RuntimeException("Professor not found")), protocolRepository.findById(protocolAssessmentRequest.getProtocolId()).orElseThrow(() -> new RuntimeException("Protocol not found")));
        evaluationRespository.save(EvaluationMapper.map(protocolAssessmentRequest.getEvaluationDTO(), sinodal));
        
    }
}
