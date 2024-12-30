package com.sgpttt.UtilsService.repository;

import com.sgpttt.UtilsService.entity.ChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long> {
    List<ChangeRequest> findChangeRequestByProtocol_ProtocolId(Long protocolProtocolId);
}
