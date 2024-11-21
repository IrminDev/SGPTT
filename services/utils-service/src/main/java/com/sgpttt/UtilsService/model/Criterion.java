package com.sgpttt.UtilsService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Criterion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long criterion_id;

    private String criterion;

    // Getters and Setters
    public Long getCriterion_id() {
        return criterion_id;
    }
    public void setCriterion_id(Long criterion_id) {
        this.criterion_id = criterion_id;
    }

    public String getCriterion() {
        return criterion;
    }
    public void setCriterion(String criterion) {
        this.criterion = criterion;
    }
}
