package sgptt.adminsvc.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="person_id")
    private Long personId;

    @NonNull
    @Column(name="name", nullable = false, length = 50)
    private String name;

    @NonNull
    @Column(name="paternal_surname", nullable = false, length = 50)
    private String paternalSurname;

    @NonNull
    @Column(name="maternal_surname", nullable = false, length = 50)
    private String maternalSurname;

    @NonNull
    @Column(name="email", nullable = false, length = 70, unique = true)
    private String email;

    @NonNull
    @Column(name="password", nullable = false, length = 100)
    private String password;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @Column(name="is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean isActive = true;
}
