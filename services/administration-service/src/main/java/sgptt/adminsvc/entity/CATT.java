package sgptt.adminsvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.model.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class CATT extends Person{
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Column(name = "catt_id")
    private String cattId;
}
