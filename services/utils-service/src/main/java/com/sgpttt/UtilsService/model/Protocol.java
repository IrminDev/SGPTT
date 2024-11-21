package com.sgpttt.UtilsService.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long protocol_id;

    private String title;

    private String keywords;

    @Lob
    @Column(name="abstract")
    private String protocolAbstract;

    @Lob
    private byte[] file_data;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private ProtocolState state;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created_at;

    
    // Getters and Setters
    public Long getProtocol_id() {
        return protocol_id;
    }
    public void setProtocol_id(Long protocol_id) {
        this.protocol_id = protocol_id;
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

    public byte[] getFile_data() {
        return file_data;
    }
    public void setFile_data(byte[] file_data) {
        this.file_data = file_data;
    }

    public ProtocolState getState() {
        return state;
    }
    public void setState(ProtocolState state) {
        this.state = state;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Protocol() {
    }

    public Protocol(String title, String keywords, String protocolAbstract, byte[] file_data, ProtocolState state, Timestamp created_at) {
        this.title = title;
        this.keywords = keywords;
        this.protocolAbstract = protocolAbstract;
        this.file_data = file_data;
        this.state = state;
        this.created_at = created_at;
    }
}