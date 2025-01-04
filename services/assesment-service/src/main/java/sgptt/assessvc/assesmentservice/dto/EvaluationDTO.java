package sgptt.assessvc.assesmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDTO {

    private Long professorId;
    private List<CriterionDTO> evaluationCriteria;
    private String comments;

}
