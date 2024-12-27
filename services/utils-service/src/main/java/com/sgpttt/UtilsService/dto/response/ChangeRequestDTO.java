package com.sgpttt.UtilsService.dto.response;

import com.sgpttt.UtilsService.model.State;

public class ChangeRequestDTO {
    private Long id;

    private byte[] formatData;

    private String requestComments;

    private String createdAt;

    private State state;

    private Long protocolId;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFormatData() {
        return formatData;
    }

    public void setFormatData(byte[] formatData) {
        this.formatData = formatData;
    }

    public String getRequestComments() {
        return requestComments;
    }

    public void setRequestComments(String requestComments) {
        this.requestComments = requestComments;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }
}
