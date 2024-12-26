package com.sgpttt.UtilsService.dto.request;

public class UpdateChangeRequestDTO {
    private Long id;

    private Long stateId;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    // Constructors
    public UpdateChangeRequestDTO() {
    }

    public UpdateChangeRequestDTO(Long id, Long stateId) {
        this.id = id;
        this.stateId = stateId;
    }
}
