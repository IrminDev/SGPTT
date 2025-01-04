package sgptt.adminsvc.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="evaluation_id")
    private Long evaluationId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sinodal_id", insertable = false, updatable = false)
    })
    private Sinodal sinodal;

    @Column(name="is_approved")
    private boolean isApproved;

    @Column(name="evaluation_comments")
    private String evaluationComments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="evaluation_date")
    private Timestamp evaluationDate;

    @OneToMany(targetEntity = CriterionEvaluation.class)
    @JoinColumn(name = "criterion_evaluation_id", insertable = false, updatable = false)
    private List<CriterionEvaluation> criterionEvaluations;
}
