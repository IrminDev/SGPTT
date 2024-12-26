package com.sgpttt.UtilsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.ChangeRequest;

@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long> {
    
}
