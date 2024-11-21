package com.sgpttt.UtilsService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Career {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long career_id;

    private String name;

    // Getters and Setters
    public Long getCareer_id() {
        return career_id;
    }
    public void setCareer_id(Long id) {
        this.career_id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
