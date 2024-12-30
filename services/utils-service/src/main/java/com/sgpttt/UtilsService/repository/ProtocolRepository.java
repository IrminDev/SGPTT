package com.sgpttt.UtilsService.repository;

import com.sgpttt.UtilsService.entity.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {

}