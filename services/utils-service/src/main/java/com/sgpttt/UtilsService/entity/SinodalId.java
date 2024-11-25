package com.sgpttt.UtilsService.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SinodalId implements Serializable{
    @Column(name = "professor_id")
    private Long professorId;

    @Column(name = "protocol_id")
    private Long protocolId;

    public SinodalId() {
    }

    public SinodalId(Long professorId, Long protocolId) {
        this.professorId = professorId;
        this.protocolId = protocolId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
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
        if (!(o instanceof SinodalId)) return false;

        SinodalId sinodalId = (SinodalId) o;

        if (!getProfessorId().equals(sinodalId.getProfessorId())) return false;
        return getProtocolId().equals(sinodalId.getProtocolId());
    }

    @Override
    public int hashCode() {
        int result = getProfessorId().hashCode();
        result = 31 * result + getProtocolId().hashCode();
        return result;
    }
}
