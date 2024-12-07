package sgptt.adminsvc.request;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.model.domain.PersonDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private PersonDTO person;
    private String email;
    private String password;
}
