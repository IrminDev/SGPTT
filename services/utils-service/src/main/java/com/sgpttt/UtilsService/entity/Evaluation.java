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
public class Evaluation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="evaluation_id")
    private Long evaluationId;

    @ManyToOne
    @JoinColumn(name="sinodal_id")
    private Sinodal sinodal;

    @Column(name="is_approved")
    private boolean isApproved;

    @Lob
    @Column(name="evaluation_comments")
    private String evaluationComments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="evaluation_date")
    private Timestamp evaluationDate;

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

    // Constructors

    public Evaluation() {
    }

    public Evaluation(Long evaluationId, Sinodal sinodal, boolean isApproved, String evaluationComments, Timestamp evaluationDate) {
        this.evaluationId = evaluationId;
        this.sinodal = sinodal;
        this.isApproved = isApproved;
        this.evaluationComments = evaluationComments;
        this.evaluationDate = evaluationDate;
    }
}
