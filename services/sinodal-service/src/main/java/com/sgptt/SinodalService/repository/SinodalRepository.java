package com.sgptt.SinodalService.repository;

import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.entity.Sinodal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinodalRepository extends JpaRepository<Sinodal, Long> {
    List<Sinodal> findByProfessor_PersonId(Long professorPersonId);
}
