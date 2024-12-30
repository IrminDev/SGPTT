package com.sgpttt.UtilsService.entity;

import com.sgpttt.UtilsService.model.State;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class ChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Long requestId;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "format_data")
    private byte[] formatData;

    @Column(name = "request_comments")
    private String requestComments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state")
    private State state;

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    public Protocol getProtocol() {
        return protocol;
    }
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}
