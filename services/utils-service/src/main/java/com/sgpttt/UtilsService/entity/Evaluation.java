package com.sgpttt.UtilsService.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

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

    // Getters and Setters
    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Sinodal getSinodal() {
        return sinodal;
    }

    public void setSinodal(Sinodal sinodal) {
        this.sinodal = sinodal;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public String getEvaluationComments() {
        return evaluationComments;
    }

    public void setEvaluationComments(String evaluationComments) {
        this.evaluationComments = evaluationComments;
    }

    public Timestamp getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Timestamp evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public List<CriterionEvaluation> getCriterionEvaluations() {
        return criterionEvaluations;
    }

    public void setCriterionEvaluations(List<CriterionEvaluation> criterionEvaluations) {
        this.criterionEvaluations = criterionEvaluations;
    }
}
