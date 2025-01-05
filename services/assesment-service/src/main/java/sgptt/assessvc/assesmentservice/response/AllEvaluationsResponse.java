package sgptt.assessvc.assesmentservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllEvaluationsResponse {

    private Long evaluationId;
    private Long professorId;
    private Long protocolId;
    private String comments;
    private Boolean isApproved;

}
