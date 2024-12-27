package com.sgpttt.UtilsService.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Director extends Professor {
    @ManyToMany
    @JoinTable(
            name = "director_protocol",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "protocol_id")
    )
    private List<Protocol> protocols;

    public List<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
    }
}
