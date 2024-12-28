package sgptt.adminsvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.model.State;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChangeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Long requestId;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "format_data")
    private byte[] formatData;

    @Column(name = "request_comments")
    private String requestComments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state")
    private State state;

    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;
}
