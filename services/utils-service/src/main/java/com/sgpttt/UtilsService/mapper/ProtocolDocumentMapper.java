package com.sgpttt.UtilsService.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sgpttt.UtilsService.dto.response.ProtocolDocumentDTO;
import com.sgpttt.UtilsService.entity.ProtocolDocument;

@Mapper
public interface ProtocolDocumentMapper {

    ProtocolDocumentDTO protocolDocumentToProtocolDocumentDTO(ProtocolDocument protocolDocument);

    List<ProtocolDocumentDTO> protocolsToProtocolDTOs(List<ProtocolDocument> protocolDocuments);
}
