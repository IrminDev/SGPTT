package com.sgpttt.UtilsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.ProtocolState;

@Repository
public interface ProtocolStateRepository extends JpaRepository<ProtocolState, Long> {
    
}
