package sgptt.adminsvc.entity;

import java.util.Date;

import jakarta.persistence.*;
import sgptt.adminsvc.model.Criterion;

@Entity
public class CriterionEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Long evaluationId;

    @Column(name = "criterion_result", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean criterionResult;

    @Enumerated(EnumType.ORDINAL)
    private Criterion criterion;

    @Column(name = "criterion_comments", columnDefinition = "TEXT", nullable = false)
    private String criterionComments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date evaluationDate;

}
