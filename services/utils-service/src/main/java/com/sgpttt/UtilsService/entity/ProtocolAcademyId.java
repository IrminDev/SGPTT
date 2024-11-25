package com.sgpttt.UtilsService.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable
public class ProtocolAcademyId implements Serializable {
    @Column(name = "academy_id")
    private Integer academyId;

    @Column(name = "protocol_id")
    private Integer protocolId;

    public ProtocolAcademyId() {
    }

    public ProtocolAcademyId(Integer academyId, Integer protocolId) {
        this.academyId = academyId;
        this.protocolId = protocolId;
    }

    public Integer getAcademyId() {
        return academyId;
    }

    public void setAcademyId(Integer academyId) {
        this.academyId = academyId;
    }

    public Integer getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Integer protocolId) {
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

