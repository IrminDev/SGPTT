package com.sgpttt.UtilsService.repository;

import com.sgpttt.UtilsService.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("SELECT p FROM Professor p WHERE p.personId IN (SELECT s.professor.personId FROM Sinodal s WHERE s.isSinodal = true GROUP BY s.professor.personId HAVING COUNT(s.protocol) < 5)")
    List<Professor> findProfessorsWithLessThanFiveProtocols();
}
