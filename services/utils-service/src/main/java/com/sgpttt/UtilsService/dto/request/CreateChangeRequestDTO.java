package com.sgpttt.UtilsService.dto.request;

public class CreateChangeRequestDTO {
    private byte[] formatData;

    private String requestComments;

    private Long stateId;

    private Long protocolId;

    // Getters and Setters
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
    public CreateChangeRequestDTO() {
    }

    public CreateChangeRequestDTO(byte[] formatData, String requestComments, Long stateId, Long protocolId) {
        this.formatData = formatData;
        this.requestComments = requestComments;
        this.stateId = stateId;
        this.protocolId = protocolId;
    }
}
