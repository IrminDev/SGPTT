package com.sgpttt.UtilsService.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class CreateChangeRequestDTO {
    private String requestComments;
    private Long protocolId;

    public String getRequestComments() {
        return requestComments;
    }

    public void setRequestComments(String requestComments) {
        this.requestComments = requestComments;
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

    public CreateChangeRequestDTO(String requestComments, Long protocolId) {
        this.requestComments = requestComments;
        this.protocolId = protocolId;
    }
}