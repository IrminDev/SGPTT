package com.sgpttt.UtilsService.dto.request;

import com.sgpttt.UtilsService.model.State;

public class UpdateChangeRequestDTO {
    private Long id;

    private State state;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
