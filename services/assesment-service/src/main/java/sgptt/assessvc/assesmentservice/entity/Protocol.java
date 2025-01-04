package sgptt.assessvc.assesmentservice.entity;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.assessvc.assesmentservice.model.State;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Protocol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "protocol_id")
    private Long protocolId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "keywords", nullable = false, columnDefinition = "TEXT")
    private String keywords;

    @Column(name="abstract", nullable = false, columnDefinition = "TEXT")
    private String protocolAbstract;

    @Basic(fetch = FetchType.LAZY)
    @Column(name="file_data", columnDefinition = "BYTEA")
    private byte[] fileData;

    @Enumerated(EnumType.ORDINAL)
    private State state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToMany
    @JoinTable(
            name = "protocol_academy",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "academy_id")
    )
    private Set<Academy> academies;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "protocol_student",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "director",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Professor> directors;

    @OneToMany(mappedBy = "protocol")
    private Set<Sinodal> sinodals;
}