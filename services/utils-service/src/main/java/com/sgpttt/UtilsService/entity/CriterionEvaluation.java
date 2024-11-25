package com.sgpttt.UtilsService.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class CriterionEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "evaluation_id")
    private Long evaluationId;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private CriterionResult criterionResult;

    @ManyToOne
    @JoinColumn(name = "criterion_id")
    private Criterion criterion;

    @Lob
    @Column(name = "criterion_comments")
    private String criterionComments;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp evaluation_date;

    // Getters and Setters
    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public CriterionResult getCriterionResult() {
        return criterionResult;
    }
    public void setCriterionResult(CriterionResult criterionResult) {
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

    public Timestamp getEvaluation_date() {
        return evaluation_date;
    }
    public void setEvaluation_date(Timestamp evaluation_date) {
        this.evaluation_date = evaluation_date;
    }
}