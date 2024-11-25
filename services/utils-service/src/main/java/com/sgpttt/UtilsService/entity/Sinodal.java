package com.sgpttt.UtilsService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sinodal {

    @Id
    @Column(name = "sinodal_id")
    private Long sinodalId;

    @ManyToOne
    @JoinColumn(name = "professor_id", insertable = false, updatable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "protocol_id", insertable = false, updatable = false)
    private Protocol protocol;

    // Getters and Setters
    public Long getSinodalId() {
        return sinodalId;
    }

    public void setSinodalId(Long sinodalId) {
        this.sinodalId = sinodalId;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    // Constructors
    public Sinodal() {
    }

    public Sinodal(Professor professor, Protocol protocol) {
        this.professor = professor;
        this.protocol = protocol;
    }
}
