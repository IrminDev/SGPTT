package com.sgpttt.UtilsService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Criterion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "criterion_id")
    private Long criterionId;

    private String criterion;

    // Getters and Setters
    public Long getCriterionId() {
        return criterionId;
    }

    public void setCriterionId(Long criterionId) {
        this.criterionId = criterionId;
    }
    
    public String getCriterion() {
        return criterion;
    }
    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }
}
