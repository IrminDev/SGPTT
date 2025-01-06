package com.sgptt.SinodalService.dto.response;

public class SinodalDTO {
    private Long id;

    private ProfessorDTO professor;

    private ProtocolDTO protocol;
    
    private boolean isSinodal;

    public boolean isSinodal() {
        return isSinodal;
    }

    public void setSinodal(boolean isSinodal) {
        this.isSinodal = isSinodal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfessorDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDTO professor) {
        this.professor = professor;
    }

    public ProtocolDTO getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolDTO protocol) {
        this.protocol = protocol;
    }
}
