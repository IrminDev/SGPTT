package com.sgptt.SinodalService.mapper;

import com.sgptt.SinodalService.dto.response.ProtocolDTO;
import com.sgptt.SinodalService.entity.Protocol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProtocolMapper {

    ProtocolDTO protocolToProtocolDTO(Protocol protocol);

    Protocol protocolDTOToProtocol(ProtocolDTO protocolDTO);
}