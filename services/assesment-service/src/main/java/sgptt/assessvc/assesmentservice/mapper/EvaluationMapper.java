package sgptt.assessvc.assesmentservice.mapper;

import sgptt.assessvc.assesmentservice.dto.CriterionDTO;
import sgptt.assessvc.assesmentservice.dto.EvaluationDTO;
import sgptt.assessvc.assesmentservice.entity.Evaluation;
import sgptt.assessvc.assesmentservice.entity.Sinodal;

import java.sql.Timestamp;
import java.util.stream.Collectors;

public class EvaluationMapper {
    public static Evaluation map(EvaluationDTO evaluation, Sinodal sinodal) {
        return Evaluation.builder()
                .sinodal(sinodal)
                .isApproved(evaluation.getEvaluationCriteria().stream().allMatch(CriterionDTO::getResult))
                .evaluationComments(evaluation.getComments())
                .evaluationDate(new Timestamp(System.currentTimeMillis()))
                .criterionEvaluations(evaluation.getEvaluationCriteria().stream().map(CriterionEvaluationMapper::map).collect(Collectors.toList()))
                .build();
    }
}
