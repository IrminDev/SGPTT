package com.sgpttt.UtilsService.mapper;

import com.sgpttt.UtilsService.dto.response.ProtocolDocumentDTO;
import com.sgpttt.UtilsService.entity.ProtocolDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProtocolDocumentMapper {

    @Mapping(source="protocolAbstract", target="protocolAbstract")
    ProtocolDocumentDTO protocolDocumentToProtocolDocumentDTO(ProtocolDocument protocolDocument);

    @Mapping(source="protocolAbstract", target="protocolAbstract")
    List<ProtocolDocumentDTO> protocolDocumentsToProtocolDTOs(List<ProtocolDocument> protocolDocuments);
}
