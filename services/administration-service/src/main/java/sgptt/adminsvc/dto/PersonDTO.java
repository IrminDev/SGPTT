package sgptt.adminsvc.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sgptt.adminsvc.model.Career;

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

}
