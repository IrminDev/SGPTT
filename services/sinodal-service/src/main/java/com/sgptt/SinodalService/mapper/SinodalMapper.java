package com.sgptt.SinodalService.mapper;

import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.entity.Sinodal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProtocolMapper.class})
public interface SinodalMapper {

    @Mapping(target = "professorId", source = "professor.personId")
    @Mapping(target = "protocol", source = "protocol")
    SinodalDTO sinodalToSinodalDTO(Sinodal sinodal);

    @Mapping(target = "professor.personId", source = "professorId")
    @Mapping(target = "protocol.protocolId", source = "protocolId")
    List<SinodalDTO> sinodalToSinodalDTO(List<Sinodal> sinodal);
}