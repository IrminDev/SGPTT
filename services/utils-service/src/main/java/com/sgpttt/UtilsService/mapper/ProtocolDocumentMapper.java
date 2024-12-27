package com.sgpttt.UtilsService.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sgpttt.UtilsService.dto.response.ProtocolDocumentDTO;
import com.sgpttt.UtilsService.entity.ProtocolDocument;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProtocolDocumentMapper {

    @Mapping(source="protocolAbstract", target="protocolAbstract")
    ProtocolDocumentDTO protocolDocumentToProtocolDocumentDTO(ProtocolDocument protocolDocument);

    @Mapping(source="protocolAbstract", target="protocolAbstract")
    List<ProtocolDocumentDTO> protocolDocumentsToProtocolDTOs(List<ProtocolDocument> protocolDocuments);
}
