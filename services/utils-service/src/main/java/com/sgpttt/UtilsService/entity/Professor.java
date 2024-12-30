package com.sgpttt.UtilsService.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "person_id")
public class Professor extends Person {
    @Column(name = "professor_number", nullable = false, length = 10)
    private String professorNumber;

    @ManyToOne(targetEntity = Academy.class)
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @Column(name = "school", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'ESCOM'")
    private String school;

    @OneToMany(mappedBy = "professor")
    private Set<Sinodal> sinodals;

    @ManyToMany
    @JoinTable(
        name = "director",
        joinColumns = @JoinColumn(name = "person_id"),
        inverseJoinColumns = @JoinColumn(name = "protocol_id")
    )
    private Set<Protocol> protocols;

    public Set<Sinodal> getSinodals() {
        return sinodals;
    }

    public void setSinodals(Set<Sinodal> sinodals) {
        this.sinodals = sinodals;
    }

    public Set<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<Protocol> protocols) {
        this.protocols = protocols;
    }

    public String getProfessorNumber() {
        return professorNumber;
    }

    public void setProfessorNumber(String professorNumber) {
        this.professorNumber = professorNumber;
    }

    public Academy getAcademy() {
        return academy;
    }
    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
}