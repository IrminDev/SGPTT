package com.sgptt.documentBuilderService.entity;

import jakarta.persistence.*;

@Entity
public class Sinodal{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Professor professor;

    @Column(name = "is_sinodal", nullable = false, columnDefinition = "boolean default true")
    private boolean isSinodal;

    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

    public boolean isSinodal() {
        return isSinodal;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSinodal(boolean isActive) {
        this.isSinodal = isActive;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
}