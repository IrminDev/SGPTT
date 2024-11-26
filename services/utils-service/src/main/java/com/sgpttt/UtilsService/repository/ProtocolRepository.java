package com.sgpttt.UtilsService.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.Academy;
import com.sgpttt.UtilsService.entity.Protocol;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
    @Query("SELECT a FROM Academy a JOIN ProtocolAcademy pa ON a.academy_id = pa.academy_id WHERE pa.protocol_id = ?1")
    public List<Academy> findAcademyByProtocolId(String protocolId);
}
