package com.sgpttt.UtilsService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Director {
    @Id
    @Column(name = "director_id")
    private Long directorId;

    @ManyToOne
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Protocol protocol;

    @ManyToOne
    @JoinColumn(name = "professor_id", insertable = false, updatable = false)
    private Professor professor;

    // Getters and Setters
    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    // Constructors
    public Director() {
    }

    public Director(Long directorId, Protocol protocol, Professor professor) {
        this.directorId = directorId;
        this.protocol = protocol;
        this.professor = professor;
    }
}
