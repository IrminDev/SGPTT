package com.sgpttt.UtilsService.entity;

import jakarta.persistence.*;

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