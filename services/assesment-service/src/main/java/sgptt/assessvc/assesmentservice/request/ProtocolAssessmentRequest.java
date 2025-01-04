package sgptt.assessvc.assesmentservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.assessvc.assesmentservice.dto.EvaluationDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProtocolAssessmentRequest {

    private Integer protocolId;
    private EvaluationDTO evaluationDTO;

}
