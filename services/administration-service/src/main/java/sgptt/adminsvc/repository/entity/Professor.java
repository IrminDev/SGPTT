package sgptt.adminsvc.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor {
    @Id
    @Column(name = "person_id")
    private Long personId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "professor_id")
    private String professorNumber;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    private String school;
}