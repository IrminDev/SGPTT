package com.sgpttt.UtilsService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProtocolState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long state_id;

    private String name;

    public ProtocolState() {
    }

    public ProtocolState(String name) {
        this.name = name;
    }

    public Long getState_id() {
        return state_id;
    }
    public void setState_id(Long state_id) {
        this.state_id = state_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}