package sgptt.assessvc.assesmentservice.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private Long evaluationId;

    @ManyToOne
    @JoinColumn(name = "sinodal_id", updatable = false, nullable = false)
    private Sinodal sinodal;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "evaluation_comments")
    private String evaluationComments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "evaluation_date")
    private Timestamp evaluationDate;

    @OneToMany(targetEntity = CriterionEvaluation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "criterion_evaluation_id", updatable = false, nullable = false)
    private List<CriterionEvaluation> criterionEvaluations;
}
