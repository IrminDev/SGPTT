package com.sgpttt.authservice.repository.entity

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="person_id")
    val personId: Long,
    val name: String,
    @Column(name="paternal_surname")
    val paternalSurname: String,
    @Column(name="maternal_surname")
    val maternalSurname: String,
    val email: String,
    val password: String,
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    val createdAt: Timestamp,
    @Column(name="is_active")
    val isActive: Boolean
)
