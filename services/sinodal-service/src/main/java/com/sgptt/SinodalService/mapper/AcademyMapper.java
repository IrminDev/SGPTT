package com.sgptt.SinodalService.mapper;

import com.sgptt.SinodalService.dto.response.AcademyDTO;
import com.sgptt.SinodalService.entity.Academy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademyMapper {
    AcademyDTO academyToAcademyDTO(Academy academy);
}
