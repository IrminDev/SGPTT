package com.sgpttt.UtilsService.entity;

import java.sql.Timestamp;
import java.util.Set;

import com.sgpttt.UtilsService.model.State;
import jakarta.persistence.*;

@Entity
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocol_id")
    private Long protocolId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "keywords", nullable = false, columnDefinition = "TEXT")
    private String keywords;

    @Column(name="abstract", nullable = false, columnDefinition = "TEXT")
    private String protocolAbstract;

    @Basic(fetch = FetchType.LAZY)
    @Column(name="file_data", nullable = false, columnDefinition = "BYTEA")
    private byte[] fileData;

    @Enumerated(EnumType.ORDINAL)
    private State state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp createdAt;

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
        name = "protocol_director",
        joinColumns = @JoinColumn(name = "protocol_id"),
        inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Director> directors;

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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
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

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }
}