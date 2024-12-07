package sgptt.adminsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgptt.adminsvc.model.domain.PersonDTO;
import sgptt.adminsvc.repository.*;
import sgptt.adminsvc.repository.entity.Person;
import sgptt.adminsvc.repository.entity.Professor;
import sgptt.adminsvc.repository.entity.Student;

import java.sql.Timestamp;

@Service
public class RegisterService {

    private final AcademyRepository academyRepository;
    private final CareerRepository careerRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public RegisterService(AcademyRepository academyRepository, ProfessorRepository professorRepository, CareerRepository careerRepository, StudentRepository studentRepository, PersonRepository personRepository, RoleRepository roleRepository) {
        this.academyRepository = academyRepository;
        this.careerRepository = careerRepository;
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    public void insertNewUser(PersonDTO personDTO, String email, String password) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setPaternalSurname(personDTO.getLastName());
        person.setMaternalSurname(personDTO.getSurname());
        person.setEmail(email);
        person.setPassword(personRepository.crypt(password));
        person.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        person.setActive(true);

        if (personDTO instanceof PersonDTO.Professor professorDTO) {
            person.setRole(roleRepository.findByName("Profesor"));
            personRepository.save(person);

            Professor professor = new Professor();
            professor.setPerson(person);
            professor.setAcademy(academyRepository.findByName(professorDTO.getArea().name()));
            professor.setProfessorNumber(personDTO.getNumber());
            professor.setSchool(professorDTO.getSchool());
            professorRepository.save(professor);

        } else if (personDTO instanceof PersonDTO.Student studentDTO) {
            person.setRole(roleRepository.findByName("Estudiante"));
            personRepository.save(person);

            Student student = new Student();
            student.setPerson(person);
            student.setCareer(careerRepository.findByName(studentDTO.getCareer().name()));
            student.setStudentNumber(studentDTO.getNumber());
            studentRepository.save(student);
        }
    }
}
