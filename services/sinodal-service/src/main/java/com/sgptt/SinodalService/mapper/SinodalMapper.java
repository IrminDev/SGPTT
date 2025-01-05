package com.sgptt.SinodalService.mapper;

import com.sgptt.SinodalService.dto.response.SinodalDTO;
import com.sgptt.SinodalService.entity.Sinodal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProtocolMapper.class, ProfessorMapper.class})
public interface SinodalMapper {

    @Mapping(target = "protocol", source = "protocol")
    @Mapping(source = "protocol.createdAt", target = "protocol.createdAt", dateFormat = "dd-MM-yyyy")
    SinodalDTO sinodalToSinodalDTO(Sinodal sinodal);

    @Mapping(target = "protocol.protocolId", source = "protocolId")
    List<SinodalDTO> sinodalToSinodalDTO(List<Sinodal> sinodal);
}