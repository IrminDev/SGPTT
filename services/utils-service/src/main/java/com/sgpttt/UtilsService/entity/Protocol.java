package com.sgpttt.UtilsService.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "protocol_id")
    private Long protocolId;

    private String title;

    private String keywords;

    @Column(name="abstract")
    private String protocolAbstract;

    @Column(name="file_data")
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private ProtocolState state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp createdAt;

    
    // Getters and Setters
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

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public ProtocolState getState() {
        return state;
    }
    public void setState(ProtocolState state) {
        this.state = state;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Protocol() {
    }

    public Protocol(Long protocolId, String title, String keywords, String protocolAbstract, byte[] fileData, ProtocolState state, Timestamp createdAt) {
        this.protocolId = protocolId;
        this.title = title;
        this.keywords = keywords;
        this.protocolAbstract = protocolAbstract;
        this.fileData = fileData;
        this.state = state;
        this.createdAt = createdAt;
    }
}