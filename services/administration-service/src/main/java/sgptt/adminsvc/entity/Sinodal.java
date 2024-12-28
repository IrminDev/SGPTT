package sgptt.adminsvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Sinodal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Professor professor;

    @Column(name = "is_sinodal", nullable = false, columnDefinition = "boolean default true")
    private boolean isSinodal;

    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

}
