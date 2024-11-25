package com.sgpttt.UtilsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.Protocol;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
    
    
}
