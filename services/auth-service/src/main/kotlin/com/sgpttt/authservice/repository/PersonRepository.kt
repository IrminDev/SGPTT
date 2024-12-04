package com.sgpttt.authservice.repository

import com.sgpttt.authservice.repository.entity.Person
import com.sgpttt.authservice.repository.model.LoginResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PersonRepository : JpaRepository<Person, Int> {

    @Query("select * from login(:_email, :_password)", nativeQuery = true)
    fun login(@Param("_email") email: String, @Param("_password") password: String): LoginResult

}