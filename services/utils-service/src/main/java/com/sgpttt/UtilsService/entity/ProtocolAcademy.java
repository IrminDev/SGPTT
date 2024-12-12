package com.sgpttt.UtilsService.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProtocolAcademy")
public class ProtocolAcademy {

    @EmbeddedId
    private ProtocolAcademyId id;

    @ManyToOne
    @JoinColumn(name = "academy_id", insertable = false, updatable = false)
    private Academy academy;

    @ManyToOne
    @JoinColumn(name = "protocol_id", insertable = false, updatable = false)
    private Protocol protocol;

    // Getters and Setters
    public ProtocolAcademyId getId() {
        return id;
    }

    public void setId(ProtocolAcademyId id) {
        this.id = id;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}