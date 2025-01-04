package com.sgptt.documentBuilderService.repository;

import com.sgptt.documentBuilderService.entity.ChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long> {

    @Query("SELECT formatData FROM ChangeRequest WHERE requestId = ?1")
    byte[] getFormatDataByRequestId(Long requestId);
}
