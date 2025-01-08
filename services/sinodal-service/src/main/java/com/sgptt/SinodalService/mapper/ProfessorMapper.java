package com.sgptt.SinodalService.mapper;

import com.sgptt.SinodalService.dto.response.ProfessorDTO;
import com.sgptt.SinodalService.entity.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AcademyMapper.class})
public interface ProfessorMapper {
    ProfessorDTO professorToProfessorDTO(Professor professor);

    List<ProfessorDTO> professorToProfessorDTO(List<Professor> professor);
}
