package com.sgpttt.UtilsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.ProtocolAcademy;

@Repository
public interface ProtocolAcademyRepository extends JpaRepository<ProtocolAcademy, Long> {
    
}
