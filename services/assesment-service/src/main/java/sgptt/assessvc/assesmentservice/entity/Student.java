package sgptt.assessvc.assesmentservice.entity;

import jakarta.persistence.*;
import lombok.*;
import sgptt.assessvc.assesmentservice.model.Career;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "person_id")
public class Student extends Person {

    @Enumerated(EnumType.ORDINAL)
    private Career career;

    @Column(name = "student_id", nullable = false, length = 10, unique = true)
    private String studentId;

    private boolean isIrregular;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "protocol_person",
            joinColumns = @JoinColumn(name = "protocol_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<Protocol> protocols;

    @Builder
    public Student (String name, String paternalSurname, String maternalSurname, String email, String pass, Date createdAt, Career career, String studentId, boolean isIrregular) {
        super(name, paternalSurname, maternalSurname, email, pass, createdAt);
        this.career = career;
        this.studentId = studentId;
        this.isIrregular = isIrregular;
    }
}
