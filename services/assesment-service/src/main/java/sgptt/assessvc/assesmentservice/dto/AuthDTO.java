package sgptt.assessvc.assesmentservice.dto;

public class AuthDTO {
    private Long personId;

    private String role;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
