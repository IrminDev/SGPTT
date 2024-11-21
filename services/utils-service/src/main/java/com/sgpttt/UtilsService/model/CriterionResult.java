package com.sgpttt.UtilsService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CriterionResult {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long result_id;

    private String result;

    // Getters and Setters
    public Long getResult_id() {
        return result_id;
    }
    public void setResult_id(Long result_id) {
        this.result_id = result_id;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
