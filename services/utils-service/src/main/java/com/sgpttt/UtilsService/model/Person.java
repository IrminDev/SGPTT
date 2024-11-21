package com.sgpttt.UtilsService.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long person_id;

    private String name;
    private String paternal_surname;
    private String maternal_surname;
    private String email;
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp created_at;

    private boolean is_active;

    // Getters and Setters
    public Long getPerson_id() {
        return person_id;
    }
    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPaternal_surname() {
        return paternal_surname;
    }
    public void setPaternal_surname(String paternal_surname) {
        this.paternal_surname = paternal_surname;
    }

    public String getMaternal_surname() {
        return maternal_surname;
    }
    public void setMaternal_surname(String maternal_surname) {
        this.maternal_surname = maternal_surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public boolean getIs_active() {
        return is_active;
    }
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    // Constructors
    public Person() {
    }

    public Person(Long person_id, String name, String paternal_surname, String maternal_surname, String email, String password, Timestamp created_at, boolean is_active) {
        this.person_id = person_id;
        this.name = name;
        this.paternal_surname = paternal_surname;
        this.maternal_surname = maternal_surname;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.is_active = is_active;
    }
}   
