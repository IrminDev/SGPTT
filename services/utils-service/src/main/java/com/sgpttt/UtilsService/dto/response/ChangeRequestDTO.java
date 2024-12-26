package com.sgpttt.UtilsService.dto.response;

public class ChangeRequestDTO {
    private Long id;

    private byte[] formatData;

    private String requestComments;

    private String createdAt;

    private Long stateId;

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

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    // Constructors
    public ChangeRequestDTO() {
    }

    public ChangeRequestDTO(Long id, byte[] formatData, String requestComments, String createdAt, Long stateId, Long protocolId) {
        this.id = id;
        this.formatData = formatData;
        this.requestComments = requestComments;
        this.createdAt = createdAt;
        this.stateId = stateId;
        this.protocolId = protocolId;
    }
}
