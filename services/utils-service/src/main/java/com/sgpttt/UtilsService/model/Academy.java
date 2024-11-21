package com.sgpttt.UtilsService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long academy_id;

    private String name;

    // Getters and Setters
    public Long getAcademy_id() {
        return academy_id;
    }
    public void setAcademy_id(Long academy_id) {
        this.academy_id = academy_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
