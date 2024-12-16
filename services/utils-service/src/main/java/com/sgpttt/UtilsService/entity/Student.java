package com.sgpttt.UtilsService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @Column (name = "person_id")
    private Long personId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "career_id")
    private Career career;

    private String student_id;

    private boolean recursor;

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

    public Career getCareer() {
        return career;
    }
    public void setCareer(Career career) {
        this.career = career;
    }

    public String getStudent_id() {
        return student_id;
    }
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public boolean isRecursor() {
        return recursor;
    }

    public void setRecursor(boolean recursor) {
        this.recursor = recursor;
    }
}