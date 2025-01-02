package com.sgpttt.authservice.repository

import com.sgpttt.authservice.repository.entity.Person
import com.sgpttt.authservice.repository.model.LoginResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

/**
 * This interface is a simple JPA repository mapped with the entity Person with has a Long field as id
 */
@Repository
interface PersonRepository : JpaRepository<Person, Long> {
    /**
     * Try to authenticate a person with [email] and [password]
     * @return a LoginResult witch contains a personId and a field wrongPassword = false if the authentication was successfully
     * otherwise personId is -1, and wrongPassword can be true
     * @see LoginResult
     */
    @Query("select * from login(:_email, :_password)", nativeQuery = true)
    fun login(@Param("_email") email: String, @Param("_password") password: String): LoginResult

}