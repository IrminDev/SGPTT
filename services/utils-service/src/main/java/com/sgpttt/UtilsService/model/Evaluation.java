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
public class Evaluation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long evaluation_id;

    @ManyToOne
    @JoinColumn(name="sinodal_id")
    private Sinodal sinodal;

    private boolean is_approved;

    @Lob
    private String evaluation_comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp evaluation_date;

    // Getters and Setters
    public Long getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(Long evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public Sinodal getSinodal() {
        return sinodal;
    }

    public void setSinodal(Sinodal sinodal) {
        this.sinodal = sinodal;
    }

    public boolean getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(boolean is_approved) {
        this.is_approved = is_approved;
    }

    public String getEvaluation_comments() {
        return evaluation_comments;
    }

    public void setEvaluation_comments(String evaluation_comments) {
        this.evaluation_comments = evaluation_comments;
    }

    public Timestamp getEvaluation_date() {
        return evaluation_date;
    }

    public void setEvaluation_date(Timestamp evaluation_date) {
        this.evaluation_date = evaluation_date;
    }

    // Constructors

    public Evaluation() {
    }

    public Evaluation(Long evaluation_id, Sinodal sinodal, boolean is_approved, String evaluation_comments,
            Timestamp evaluation_date) {
        this.evaluation_id = evaluation_id;
        this.sinodal = sinodal;
        this.is_approved = is_approved;
        this.evaluation_comments = evaluation_comments;
        this.evaluation_date = evaluation_date;
    }
}
