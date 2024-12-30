package com.sgptt.SinodalService.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academy_id")
    private Long academyId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Protocol> protocols;

    // Getters and Setters
    public Long getAcademyId() {
        return academyId;
    }
    public void setAcademyId(Long academyId) {
        this.academyId = academyId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<Protocol> protocols) {
        this.protocols = protocols;
    }
}