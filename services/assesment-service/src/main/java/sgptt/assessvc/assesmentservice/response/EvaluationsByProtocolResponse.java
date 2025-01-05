package sgptt.assessvc.assesmentservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.assessvc.assesmentservice.entity.CriterionEvaluation;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationsByProtocolResponse {

    private Long professorId;
    private List<CriterionEvaluation> evaluationCriteria;
    private String comments;
    private Boolean isApproved;

}
