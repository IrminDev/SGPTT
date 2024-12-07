package sgptt.adminsvc.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.model.domain.Activity;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {

    private Activity activity;
    private Date startDate;
    private Date endDate;

}