package com.sgptt.documentBuilderService.repository;

import com.sgptt.documentBuilderService.entity.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {

    @Query("SELECT fileData FROM Protocol WHERE protocolId = ?1")
    byte[] getFileDataByProtocolId(Long protocolId);
}
