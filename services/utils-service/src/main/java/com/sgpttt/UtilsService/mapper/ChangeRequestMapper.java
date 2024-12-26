package com.sgpttt.UtilsService.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sgpttt.UtilsService.dto.response.ChangeRequestDTO;
import com.sgpttt.UtilsService.entity.ChangeRequest;

@Mapper(componentModel = "spring")
public interface ChangeRequestMapper {

    @Mapping(source="requestId", target="id")
    @Mapping(source="createdAt", target="createdAt", dateFormat="yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source="state.stateId", target="stateId")
    @Mapping(source="protocol.protocolId", target="protocolId")
    ChangeRequestDTO changeRequestToChangeRequestDTO(ChangeRequest changeRequest);

    @Mapping(source="requestId", target="id")
    @Mapping(source="createdAt", target="createdAt", dateFormat="yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source="state.stateId", target="stateId")
    @Mapping(source="protocol.protocolId", target="protocolId")
    List<ChangeRequestDTO> changeRequestsToChangeRequestDTOs(List<ChangeRequest> changeRequests);
}
