package com.sgpttt.UtilsService.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sgpttt.UtilsService.dto.response.ProfessorDTO;
import com.sgpttt.UtilsService.entity.Professor;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    
    @Mapping(source="personId", target="id")
    @Mapping(source="academy.academyId", target="academy")
    ProfessorDTO professorToProfessorDTO(Professor professor);

    @Mapping(source="personId", target="id")
    @Mapping(source="academy.academyId", target="academy")
    List<ProfessorDTO> professorsToProfessorDTOs(List<Professor> professors);
}