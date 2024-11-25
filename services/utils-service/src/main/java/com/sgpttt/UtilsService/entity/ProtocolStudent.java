package com.sgpttt.UtilsService.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProtocolStudent {

    @EmbeddedId
    private ProtocolStudentId id;

    @ManyToOne
    @JoinColumn(name="protocol_id")
    private Protocol protocol;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    // Getters and Setters
    public ProtocolStudentId getId() {
        return id;
    }

    public void setId(ProtocolStudentId id) {
        this.id = id;
    }

    public Protocol getProtocol() {
        return protocol;
    }
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public ProtocolStudent() {
    }

    public ProtocolStudent(Protocol protocol, Student student) {
        this.protocol = protocol;
        this.student = student;
    }
}
