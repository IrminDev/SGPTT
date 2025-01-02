package com.sgpttt.UtilsService.mapper;

import com.sgpttt.UtilsService.dto.response.ChangeRequestDTO;
import com.sgpttt.UtilsService.entity.ChangeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChangeRequestMapper {

    @Mapping(source="requestId", target="id")
    @Mapping(source="createdAt", target="createdAt", dateFormat="yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source="protocol.protocolId", target="protocolId")
    @Mapping(source="changeRequest", target="filePath", qualifiedByName = "mapFilePath")
    ChangeRequestDTO changeRequestToChangeRequestDTO(ChangeRequest changeRequest, @org.mapstruct.Context String documentBuilderUrl);

    @Mapping(source="requestId", target="id")
    @Mapping(source="createdAt", target="createdAt", dateFormat="yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source="protocol.protocolId", target="protocolId")
    @Mapping(source="changeRequest", target="filePath", qualifiedByName = "mapFilePath")
    List<ChangeRequestDTO> changeRequestsToChangeRequestDTOs(List<ChangeRequest> changeRequests, @org.mapstruct.Context String documentBuilderUrl);

    @Named("mapFilePath")
    default String mapFilePath(ChangeRequest changeRequest, @org.mapstruct.Context String documentBuilderUrl) {
        return documentBuilderUrl + "/api/document/change-request/" + changeRequest.getRequestId();
    }
}