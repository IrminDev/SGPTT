package com.sgpttt.UtilsService.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProtocolAcademyId implements Serializable {
    @Column(name = "academy_id")
    private Long academyId;

    @Column(name = "protocol_id")
    private Long protocolId;

    public ProtocolAcademyId() {
    }

    public ProtocolAcademyId(Long academyId, Long protocolId) {
        this.academyId = academyId;
        this.protocolId = protocolId;
    }

    public Long getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtocolAcademyId that = (ProtocolAcademyId) o;
        return Objects.equals(academyId, that.academyId) &&
               Objects.equals(protocolId, that.protocolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(academyId, protocolId);
    }
}