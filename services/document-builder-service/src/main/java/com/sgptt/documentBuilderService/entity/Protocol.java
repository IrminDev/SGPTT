package com.sgptt.documentBuilderService.entity;

import com.sgptt.documentBuilderService.model.State;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocol_id")
    private Long protocolId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "keywords", nullable = false, columnDefinition = "TEXT")
    private String keywords;

    @Column(name="abstract", nullable = false, columnDefinition = "TEXT")
    private String protocolAbstract;

    @Basic(fetch = FetchType.LAZY)
    @Column(name="file_data", columnDefinition = "BYTEA")
    private byte[] fileData;

    @Enumerated(EnumType.ORDINAL)
    private State state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @ManyToMany
    @JoinTable(
            name = "protocol_academy",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "academy_id")
    )
    private Set<Academy> academies;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "protocol_student",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "director",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Professor> directors;

    @OneToMany(mappedBy = "protocol")
    private Set<Sinodal> sinodals;

    // Getters and Setters
    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getProtocolAbstract() {
        return protocolAbstract;
    }
    public void setProtocolAbstract(String protocolAbstract) {
        this.protocolAbstract = protocolAbstract;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Academy> getAcademies() {
        return academies;
    }

    public void setAcademies(Set<Academy> academies) {
        this.academies = academies;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Professor> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Professor> directors) {
        this.directors = directors;
    }

    public Set<Sinodal> getSinodals() {
        return sinodals;
    }

    public void setSinodals(Set<Sinodal> sinodals) {
        this.sinodals = sinodals;
    }
}