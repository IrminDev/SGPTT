package com.sgpttt.authservice.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Role(
    @Id
    @Column(name = "role_id")
    val roleId: Int,
    
    val name: String
)
