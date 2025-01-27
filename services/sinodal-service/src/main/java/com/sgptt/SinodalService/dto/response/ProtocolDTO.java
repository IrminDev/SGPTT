package com.sgptt.SinodalService.dto.response;

import com.sgptt.SinodalService.model.State;

public class ProtocolDTO {
    private Long protocolId;

    private String title;

    private String keywords;

    private String protocolAbstract;

    private State state;

    private String createdAt;

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getProtocolAbstract() {
        return protocolAbstract;
    }

    public void setProtocolAbstract(String protocolAbstract) {
        this.protocolAbstract = protocolAbstract;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
