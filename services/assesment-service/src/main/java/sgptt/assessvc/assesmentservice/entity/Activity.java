package sgptt.assessvc.assesmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.assessvc.assesmentservice.model.ActivityName;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Temporal(TemporalType.DATE)
    private Date openDate;

    @Temporal(TemporalType.DATE)
    private Date closeDate;

    @Enumerated(EnumType.ORDINAL)
    private ActivityName activity;
}
