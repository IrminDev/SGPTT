package com.sgpttt.UtilsService.dto.response;

public class ProtocolDocumentDTO {
    private Long id;
    private String title;
    private String keywords;
    private String protocolAbstract;
    private float score; // Add score field

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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
