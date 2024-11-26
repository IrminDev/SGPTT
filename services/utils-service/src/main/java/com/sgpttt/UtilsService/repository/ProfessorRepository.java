package com.sgpttt.UtilsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
