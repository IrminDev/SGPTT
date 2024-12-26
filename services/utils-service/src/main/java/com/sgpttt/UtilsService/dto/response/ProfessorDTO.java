package com.sgpttt.UtilsService.dto.response;

public class ProfessorDTO {
    private Long id;

    private String professorNumber;

    private Long academy;

    private String school;

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

    // Constructors
    public ProfessorDTO() {
    }

    public ProfessorDTO(Long id, String professorNumber, Long academy, String school) {
        this.id = id;
        this.professorNumber = professorNumber;
        this.academy = academy;
        this.school = school;
    }
}
