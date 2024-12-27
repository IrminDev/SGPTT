package com.sgpttt.UtilsService.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class CreateChangeRequestDTO {
    private MultipartFile file;
    private String requestComments;
    private Long protocolId;

    // Getters and Setters
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

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

    public CreateChangeRequestDTO(MultipartFile file, String requestComments, Long protocolId) {
        this.file = file;
        this.requestComments = requestComments;
        this.protocolId = protocolId;
    }
}