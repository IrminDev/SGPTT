package sgptt.assessvc.assesmentservice.mapper;

import sgptt.assessvc.assesmentservice.dto.CriterionDTO;
import sgptt.assessvc.assesmentservice.entity.CriterionEvaluation;

public class CriterionEvaluationMapper {
    public static CriterionEvaluation map(CriterionDTO criterion) {
        return CriterionEvaluation.builder()
                .criterionResult(criterion.getResult())
                .criterion(criterion.getCriterion())
                .criterionComments(criterion.getComment())
                .build();
    }
}
