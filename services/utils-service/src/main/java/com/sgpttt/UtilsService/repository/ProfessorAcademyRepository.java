package com.sgpttt.UtilsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorAcademyRepository extends JpaRepository<ProfessorRepository, Long> {
    
}
