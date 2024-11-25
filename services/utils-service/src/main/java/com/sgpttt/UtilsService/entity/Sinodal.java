package com.sgpttt.UtilsService.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Sinodal {
    @EmbeddedId
    private SinodalId id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

    // Getters and Setters
    public SinodalId getId() {
        return id;
    }

    public void setId(SinodalId id) {
        this.id = id;
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
