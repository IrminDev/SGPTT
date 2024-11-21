package com.sgpttt.UtilsService.model;

import java.sql.Timestamp;

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
public class ChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long request_id;

    @Lob
    private byte[] format_data;

    @Lob
    private String request_comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private ProtocolState state;

    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

    // Getters and Setters
    public Long getRequest_id() {
        return request_id;
    }
    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public byte[] getFormat_data() {
        return format_data;
    }
    public void setFormat_data(byte[] format_data) {
        this.format_data = format_data;
    }

    public String getRequest_comments() {
        return request_comments;
    }
    public void setRequest_comments(String request_comments) {
        this.request_comments = request_comments;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public ProtocolState getState() {
        return state;
    }
    public void setState(ProtocolState state) {
        this.state = state;
    }

    public Protocol getProtocol() {
        return protocol;
    }
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}
