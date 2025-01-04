package sgptt.adminsvc.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.dto.PersonDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private PersonDTO person;
    private String email;
    private String password;
}
