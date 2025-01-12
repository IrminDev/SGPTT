package sgptt.assessvc.assesmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgptt.assessvc.assesmentservice.entity.Evaluation;
import sgptt.assessvc.assesmentservice.entity.Sinodal;
import sgptt.assessvc.assesmentservice.repository.EvaluationRepository;
import sgptt.assessvc.assesmentservice.response.AllEvaluationsResponse;
import sgptt.assessvc.assesmentservice.response.EvaluationResponse;
import sgptt.assessvc.assesmentservice.response.EvaluationsByProfessorResponse;
import sgptt.assessvc.assesmentservice.response.EvaluationsByProtocolResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetEvaluationsService {

    public final EvaluationRepository evaluationRepository;

    @Autowired
    public GetEvaluationsService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<EvaluationsByProtocolResponse> getEvaluationsByProtocol(Long protocolId) {
        List<Evaluation> evaluations = evaluationRepository.findEvaluationBySinodal_ProtocolProtocolId(protocolId);
        ArrayList<EvaluationsByProtocolResponse> evaluationsByProtocol = new ArrayList<>();

        for (Evaluation evaluation : evaluations)
            evaluationsByProtocol.add(new EvaluationsByProtocolResponse(evaluation.getSinodal().getProfessor().getPersonId(), evaluation.getCriterionEvaluations(), evaluation.getEvaluationComments(), evaluation.getIsApproved()));

        return evaluationsByProtocol;
    }

    public List<EvaluationsByProfessorResponse> getEvaluationsByProfessor(Long personId) {
        List<Evaluation> evaluations = evaluationRepository.findEvaluationsBySinodal_ProfessorPersonId(personId);
        ArrayList<EvaluationsByProfessorResponse> evaluationsByProfessor = new ArrayList<>();

        for (Evaluation evaluation : evaluations)
            evaluationsByProfessor.add(new EvaluationsByProfessorResponse(evaluation.getEvaluationId(), evaluation.getSinodal().getProtocol().getProtocolId(), evaluation.getEvaluationComments(), evaluation.getIsApproved()));

        return evaluationsByProfessor;
    }

    public List<AllEvaluationsResponse> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationRepository.findAll();
        ArrayList<AllEvaluationsResponse> allEvaluations = new ArrayList<>();

        for (Evaluation evaluation : evaluations)
            allEvaluations.add(new AllEvaluationsResponse(evaluation.getEvaluationId(), evaluation.getSinodal().getProfessor().getPersonId(), evaluation.getSinodal().getProtocol().getProtocolId(), evaluation.getEvaluationComments(), evaluation.getIsApproved()));

        return allEvaluations;
    }

    public EvaluationResponse getEvaluationById(Long evaluationId) {
        Evaluation evaluation = evaluationRepository.findById(evaluationId).orElseThrow(() -> new RuntimeException("Evaluation not found"));
        return new EvaluationResponse(evaluation.getSinodal().getProtocol().getProtocolId(), evaluation.getSinodal().getProfessor().getPersonId(), evaluation.getCriterionEvaluations(), evaluation.getEvaluationComments(), evaluation.getIsApproved());
    }

    public void deleteEvaluationsByProtocol(Long protocolId) {
        evaluationRepository.deleteEvaluationsBySinodal_ProtocolProtocolId(protocolId);
    }

}
