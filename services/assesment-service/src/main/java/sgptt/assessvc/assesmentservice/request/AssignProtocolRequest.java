package sgptt.assessvc.assesmentservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignProtocolRequest {

    private Integer protocolId;
    private Set<Long> academies;

}
