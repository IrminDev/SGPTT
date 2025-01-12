package sgptt.assessvc.assesmentservice.service;

import sgptt.assessvc.assesmentservice.entity.*;
import sgptt.assessvc.assesmentservice.mapper.EvaluationMapper;
import sgptt.assessvc.assesmentservice.model.ActivityName;
import sgptt.assessvc.assesmentservice.repository.*;
import sgptt.assessvc.assesmentservice.request.ProtocolAssessmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static sgptt.assessvc.assesmentservice.model.State.*;

@Service
public class ProtocolAssessmentService {

    public final EvaluationRepository evaluationRespository;
    public final ProfessorRepository professorRepository;
    public final ProtocolRepository protocolRepository;
    public final ActivityRepository activityRepository;
    public final SinodalRepository sinodalRepository;

    @Autowired
    public ProtocolAssessmentService(EvaluationRepository evaluationRespository, SinodalRepository sinodalRepository, ProfessorRepository professorRepository, ProtocolRepository protocolRepository, ActivityRepository activityRepository) {
        this.evaluationRespository = evaluationRespository;
        this.professorRepository = professorRepository;
        this.protocolRepository = protocolRepository;
        this.activityRepository = activityRepository;
        this.sinodalRepository = sinodalRepository;
    }

    public void evaluate(ProtocolAssessmentRequest protocolAssessmentRequest) {
        Activity activity = activityRepository.findById(ActivityName.ASSESSMENT_PROTOCOLS.ordinal()).orElseThrow(() -> new RuntimeException("Activity not found"));
        Protocol protocol = protocolRepository.findById(protocolAssessmentRequest.getProtocolId()).orElseThrow(() -> new RuntimeException("Protocol not found"));
        Professor professor = professorRepository.findById(protocolAssessmentRequest.getEvaluationDTO().getProfessorId()).orElseThrow(() -> new RuntimeException("Professor not found"));
        Sinodal sinodal = sinodalRepository.findByProfessorAndProtocol(professor, protocol);
        Evaluation evaluation = EvaluationMapper.map(protocolAssessmentRequest.getEvaluationDTO(), sinodal);
        List<Evaluation> evaluations = evaluationRespository.findEvaluationBySinodal_ProtocolProtocolId(protocol.getProtocolId());

        Date now = new Date();
        if (now.before(activity.getOpenDate()))
            throw new RuntimeException("Activity \"REVIEW_PROTOCOLS\" not yet available");
        else if (now.after(activity.getCloseDate()))
            throw new RuntimeException("Activity \"REVIEW_PROTOCOLS\" has already ended");

        evaluationRespository.save(evaluation);
        evaluations.add(evaluation);

        if (evaluations.size() == 3)
            if (evaluations.stream().allMatch(Evaluation::getIsApproved))
                protocol.setState(APPROVED);
            else
                protocol.setState(CORRECTIONS);
        else
            protocol.setState(EVALUATING);

        protocolRepository.save(protocol);
    }
}
