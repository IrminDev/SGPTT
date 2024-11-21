package com.sgpttt.UtilsService.model;

import java.sql.Timestamp;

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
    private Long evaluation_id;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private CriterionResult criterionResult;

    @ManyToOne
    @JoinColumn(name = "criterion_id")
    private Criterion criterion;

    @Lob
    private String criterion_comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp evaluation_date;

    // Getters and Setters
    public Long getEvaluation_id() {
        return evaluation_id;
    }
    public void setEvaluation_id(Long evaluation_id) {
        this.evaluation_id = evaluation_id;
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

    public String getCriterion_comments() {
        return criterion_comments;
    }
    public void setCriterion_comments(String criterion_comments) {
        this.criterion_comments = criterion_comments;
    }

    public Timestamp getEvaluation_date() {
        return evaluation_date;
    }
    public void setEvaluation_date(Timestamp evaluation_date) {
        this.evaluation_date = evaluation_date;
    }
}