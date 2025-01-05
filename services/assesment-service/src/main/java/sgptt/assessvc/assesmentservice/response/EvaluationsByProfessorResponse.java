package sgptt.assessvc.assesmentservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationsByProfessorResponse {

    private Long evaluationId;
    private Long protocolId;
    private String comments;
    private Boolean isApproved;

}
