package sgptt.adminsvc.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.model.Career;
import sgptt.adminsvc.model.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonDTO.Student.class, name = "student"),
        @JsonSubTypes.Type(value = PersonDTO.Professor.class, name = "professor"),
        @JsonSubTypes.Type(value = PersonDTO.CATT.class, name = "catt")
})
public sealed class PersonDTO permits PersonDTO.Student, PersonDTO.Professor, PersonDTO.CATT {

    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String number;

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @JsonTypeName("person")
    public static final class Student extends PersonDTO {
        private final Career career;
        private final Boolean isIrregular;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @JsonTypeName("person")
    public static final class Professor extends PersonDTO {
        private final String school;
        private final String academyName;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @AllArgsConstructor
    @JsonTypeName("person")
    public static final class CATT extends PersonDTO {
        private final Role role;
    }

}
