package com.sgpttt.UtilsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.Professor;
import com.sgpttt.UtilsService.entity.Sinodal;

@Repository
public interface SinodalRepository extends JpaRepository<Sinodal, Long> {

    @Query("SELECT p FROM Professor p WHERE p.personId IN (SELECT s.professor.personId FROM Sinodal s WHERE s.isActive = true GROUP BY s.professor.personId HAVING COUNT(s.protocol.protocolId) < 5)")
    List<Professor> findProfessorsWithLessThanFiveProtocols();

}