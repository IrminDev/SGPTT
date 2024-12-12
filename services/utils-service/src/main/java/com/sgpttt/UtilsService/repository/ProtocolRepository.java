package com.sgpttt.UtilsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.Academy;
import com.sgpttt.UtilsService.entity.Protocol;
import com.sgpttt.UtilsService.entity.ProtocolAcademy;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {

    @Query("SELECT a FROM Academy a JOIN ProtocolAcademy pa ON a.academyId = pa.academy.academyId WHERE pa.protocol.protocolId = ?1")
    List<Academy> findAcademyByProtocolId(Long protocolId);

    @Query("SELECT pa FROM ProtocolAcademy pa")
    List<ProtocolAcademy> getProtocolsAcademy();

    @Query("SELECT pa FROM ProtocolAcademy pa WHERE pa.protocol.protocolId = ?1")
    List<ProtocolAcademy> getInfo(Long protocolId);
}