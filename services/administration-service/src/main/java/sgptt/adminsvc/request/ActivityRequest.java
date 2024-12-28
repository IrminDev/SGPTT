package sgptt.adminsvc.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.model.ActivityName;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {

    private ActivityName activity;
    private Date startDate;
    private Date endDate;

}