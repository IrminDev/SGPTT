package sgptt.adminsvc.mapper;

import sgptt.adminsvc.dto.PersonDTO;
import sgptt.adminsvc.repository.AcademyRepository;
import sgptt.adminsvc.entity.Person;
import sgptt.adminsvc.entity.Professor;
import sgptt.adminsvc.entity.Student;

import java.sql.Timestamp;

public class PersonMapper {
    public static Person map(PersonDTO personDTO, String email, String pass, AcademyRepository academyRepository) {
        return switch (personDTO) {
            case PersonDTO.Professor professor -> Professor.builder()
                    .name(professor.getName())
                    .paternalSurname(professor.getPaternalSurname())
                    .maternalSurname(professor.getMaternalSurname())
                    .email(email)
                    .pass(pass)
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .professorNumber(professor.getNumber())
                    .academy(academyRepository.findByName(professor.getAcademyName()))
                    .school(professor.getSchool())
                    .build();
            case PersonDTO.Student student -> Student.builder()
                    .name(student.getName())
                    .paternalSurname(student.getPaternalSurname())
                    .maternalSurname(student.getMaternalSurname())
                    .email(email)
                    .pass(pass)
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .studentId(student.getNumber())
                    .career(student.getCareer())
                    .isIrregular(student.getIsIrregular())
                    .build();
            default -> throw new IllegalStateException("Unexpected value: " + personDTO);
        };
    }
}
