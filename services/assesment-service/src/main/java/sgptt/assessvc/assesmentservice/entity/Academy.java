package sgptt.assessvc.assesmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academy_id")
    private Long academyId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Protocol> protocols;
}
