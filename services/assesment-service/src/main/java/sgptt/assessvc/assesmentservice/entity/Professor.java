package sgptt.assessvc.assesmentservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "person_id")
public class Professor extends Person {
    @Column(name = "professor_number", nullable = false, length = 10)
    private String professorNumber;

    @ManyToOne(targetEntity = Academy.class)
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @Column(name = "school", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'ESCOM'")
    private String school;

    @OneToMany(mappedBy = "professor")
    private Set<Sinodal> sinodals;

    @ManyToMany
    @JoinTable(
            name = "director",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "protocol_id")
    )
    private Set<Protocol> protocols;

    @Builder
    public Professor(String name, String paternalSurname, String maternalSurname, String email, String pass, Date createdAt, String professorNumber, Academy academy, String school ) {
        super(null, name, paternalSurname, maternalSurname, email, pass, createdAt, true);
        this.professorNumber = professorNumber;
        this.academy = academy;
        this.school = school;
    }
}