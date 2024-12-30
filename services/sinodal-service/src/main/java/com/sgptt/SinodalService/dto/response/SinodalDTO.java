package com.sgptt.SinodalService.dto.response;

public class SinodalDTO {
    private Long id;

    private Long professorId;

    private ProtocolDTO protocol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public ProtocolDTO getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolDTO protocol) {
        this.protocol = protocol;
    }
}
