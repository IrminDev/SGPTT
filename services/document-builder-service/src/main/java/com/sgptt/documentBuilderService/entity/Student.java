package com.sgptt.documentBuilderService.entity;

import com.sgptt.documentBuilderService.model.Career;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Student extends Person {
    @Enumerated(EnumType.ORDINAL)
    private Career career;

    @Column(name = "student_id", nullable = false, length = 10, unique = true)
    private String studentId;

    private boolean isIrregular;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "protocol_person",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Protocol> protocols;

    public Career getCareer() {
        return career;
    }
    public void setCareer(Career career) {
        this.career = career;
    }

    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String student_id) {
        this.studentId = student_id;
    }

    public boolean isIrregular() {
        return isIrregular;
    }

    public void setIrregular(boolean isIrregular) {
        this.isIrregular = isIrregular;
    }
}