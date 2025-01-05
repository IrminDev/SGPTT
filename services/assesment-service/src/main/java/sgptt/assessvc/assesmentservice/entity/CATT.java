package sgptt.assessvc.assesmentservice.entity;

import jakarta.persistence.*;
import sgptt.assessvc.assesmentservice.model.Role;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class CATT extends Person{
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Column(name = "catt_id")
    private String cattId;

}
