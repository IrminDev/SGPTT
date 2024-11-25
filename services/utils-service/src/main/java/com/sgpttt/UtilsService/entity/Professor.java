package com.sgpttt.UtilsService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Professor {
    @Id
    @Column(name = "person_id")
    private Long personId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "professor_number")
    private String professorNumber;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    private String school;

    // Getters and Setters
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
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

    public Professor() {
    }

    public Professor(Long personId, Person person, String professorNumber, Academy academy, String school) {
        this.personId = personId;
        this.person = person;
        this.professorNumber = professorNumber;
        this.academy = academy;
        this.school = school;
    }
}