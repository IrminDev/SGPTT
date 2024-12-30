package sgptt.assessvc.assesmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.assessvc.assesmentservice.model.Criterion;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriterionDTO {

    private Criterion criterion;
    private Boolean result;
    private String comment;

}
