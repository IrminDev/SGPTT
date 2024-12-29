package com.sgpttt.UtilsService.mapper;

import java.util.List;

import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sgpttt.UtilsService.dto.response.ChangeRequestDTO;
import com.sgpttt.UtilsService.entity.ChangeRequest;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
public interface ChangeRequestMapper {

    @Mapping(source="requestId", target="id")
    @Mapping(source="createdAt", target="createdAt", dateFormat="yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source="protocol.protocolId", target="protocolId")
    ChangeRequestDTO changeRequestToChangeRequestDTO(ChangeRequest changeRequest);

    @Mapping(source="requestId", target="id")
    @Mapping(source="createdAt", target="createdAt", dateFormat="yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source="protocol.protocolId", target="protocolId")
    List<ChangeRequestDTO> changeRequestsToChangeRequestDTOs(List<ChangeRequest> changeRequests);
}