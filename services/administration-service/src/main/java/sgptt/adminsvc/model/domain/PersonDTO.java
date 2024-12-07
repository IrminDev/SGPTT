package sgptt.adminsvc.model.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonDTO.Student.class, name = "student"),
        @JsonSubTypes.Type(value = PersonDTO.Professor.class, name = "professor")
})
public sealed class PersonDTO permits PersonDTO.Student, PersonDTO.Professor {

    private String name;
    private String lastName;
    private String surname;
    private String number;

    @Data
    @AllArgsConstructor
    @JsonTypeName("person")
    public static final class Student extends PersonDTO {
        private final Career career;
    }

    @Data
    @AllArgsConstructor
    @JsonTypeName("person")
    public static final class Professor extends PersonDTO {
        private final String school;
        private final Area area;
    }

}
