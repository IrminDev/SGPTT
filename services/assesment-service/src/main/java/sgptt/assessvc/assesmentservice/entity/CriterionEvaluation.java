package sgptt.assessvc.assesmentservice.entity;

import jakarta.persistence.*;
import lombok.*;
import sgptt.assessvc.assesmentservice.model.Criterion;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CriterionEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "criterion_id")
    private Long evaluationId;

    @Column(name = "criterion_result", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean criterionResult;

    @Enumerated(EnumType.ORDINAL)
    private Criterion criterion;

    @Column(name = "criterion_comments", columnDefinition = "TEXT", nullable = false)
    private String criterionComments;
}
