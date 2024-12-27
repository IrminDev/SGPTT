package com.sgpttt.UtilsService.entity;

import com.sgpttt.UtilsService.model.Role;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class CATT extends Person{
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Column(name = "catt_id")
    private String cattId;

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public String getCattId() {
        return cattId;
    }

    public void setCattId(String cattId) {
        this.cattId = cattId;
    }
}