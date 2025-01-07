package sgptt.adminsvc.entity;

import jakarta.persistence.*;
import lombok.*;
import sgptt.adminsvc.model.Role;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class CATT extends Person {
    @Enumerated(EnumType.ORDINAL)
    private Role role;

    @Column(name = "catt_id")
    private String cattId;

    @Builder
    public CATT(String name, String paternalSurname, String maternalSurname, String email, String pass, Date createdAt, Role role) {
        super(null, name, paternalSurname, maternalSurname, email, pass, createdAt, true);
        this.role = role;
    }
}
