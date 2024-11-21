package com.sgpttt.UtilsService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Professor {
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String professor_number;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    private String school;

    // Getters and Setters
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public String getProfessor_number() {
        return professor_number;
    }
    public void setProfessor_number(String professor_number) {
        this.professor_number = professor_number;
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

    public Professor(Person person, String professor_number, Academy academy, String school) {
        this.person = person;
        this.professor_number = professor_number;
        this.academy = academy;
        this.school = school;
    }
}