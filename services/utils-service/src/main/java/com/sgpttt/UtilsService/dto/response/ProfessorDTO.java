package com.sgpttt.UtilsService.dto.response;

public class ProfessorDTO {
    private Long id;

    private String professorId;

    private Long academy;

    private String school;

    private String professorNumber;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfessorNumber() {
        return professorNumber;
    }

    public void setProfessorNumber(String professorNumber) {
        this.professorNumber = professorNumber;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public Long getAcademy() {
        return academy;
    }

    public void setAcademy(Long academy) {
        this.academy = academy;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
