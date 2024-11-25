package com.sgpttt.UtilsService.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProtocolStudentId implements Serializable {
    @Column(name = "protocol_id")
    private Long protocolId;

    @Column(name = "student_id")
    private Long studentId;

    public ProtocolStudentId() {
    }

    public ProtocolStudentId(Long protocolId, Long studentId) {
        this.protocolId = protocolId;
        this.studentId = studentId;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProtocolStudentId that = (ProtocolStudentId) o;
        return protocolId.equals(that.protocolId) &&
                studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return protocolId.hashCode() + studentId.hashCode();
    }
}
