package com.sgpttt.UtilsService.entity;

import com.sgpttt.UtilsService.model.Criterion;
import jakarta.persistence.*;

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

    // Getters and Setters
    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public boolean getCriterionResult() {
        return criterionResult;
    }
    public void setCriterionResult(boolean criterionResult) {
        this.criterionResult = criterionResult;
    }

    public Criterion getCriterion() {
        return criterion;
    }
    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }

    public String getCriterionComments() {
        return criterionComments;
    }

    public void setCriterionComments(String criterionComments) {
        this.criterionComments = criterionComments;
    }

}