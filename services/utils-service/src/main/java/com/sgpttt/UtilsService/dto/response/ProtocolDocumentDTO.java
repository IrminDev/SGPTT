package com.sgpttt.UtilsService.dto.response;

public class ProtocolDocumentDTO {
    private Long id;

    private String title;

    private String keywords;

    private String protocolAbstract;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    // Constructors
    public ProtocolDocumentDTO() {
    }

    public ProtocolDocumentDTO(Long id, String title, String keywords, String protocolAbstract) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.protocolAbstract = protocolAbstract;
    }
}
