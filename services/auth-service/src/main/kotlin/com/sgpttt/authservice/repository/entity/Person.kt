package com.sgpttt.authservice.repository.entity



import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    val role: Role,
    val email: String,
    val password: String,
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    val createdAt: Timestamp,
    @Column(name="is_active")
    val isActive: Boolean
)
