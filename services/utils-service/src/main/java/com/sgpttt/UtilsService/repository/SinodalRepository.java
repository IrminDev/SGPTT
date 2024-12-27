package com.sgpttt.UtilsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sgpttt.UtilsService.entity.Professor;
import com.sgpttt.UtilsService.entity.Sinodal;

@Repository
public interface SinodalRepository extends JpaRepository<Sinodal, Long> {

}