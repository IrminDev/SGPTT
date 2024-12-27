package com.sgpttt.UtilsService.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Sinodal extends Professor{
    @Column(name = "is_active")
    private boolean isActive;

    @ManyToMany
    @JoinTable(
            name = "sinodal_protocol",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "protocol_id")
    )
    private Set<Protocol> protocols;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<Protocol> protocols) {
        this.protocols = protocols;
    }
}
