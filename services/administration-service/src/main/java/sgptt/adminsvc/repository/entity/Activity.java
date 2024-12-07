package sgptt.adminsvc.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long activityId;

    @Temporal(TemporalType.DATE)
    @Column(name = "open_date")
    private Date openDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "close_date")
    private Date closeDate;

    private String activity;
}
