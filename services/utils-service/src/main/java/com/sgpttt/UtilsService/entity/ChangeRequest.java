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
public class ChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "format_data")
    private byte[] formatData;

    @Column(name = "request_comments")
    private String requestComments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private ProtocolState state;

    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

    // Getters and Setters
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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

    // Constructors
    public ChangeRequest() {
    }

    public ChangeRequest(Long requestId, byte[] formatData, String requestComments, Timestamp createdAt, ProtocolState state, Protocol protocol) {
        this.requestId = requestId;
        this.formatData = formatData;
        this.requestComments = requestComments;
        this.createdAt = createdAt;
        this.state = state;
        this.protocol = protocol;
    }
}
