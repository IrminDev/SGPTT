package sgptt.adminsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sgptt.adminsvc.mapper.PersonMapper;
import sgptt.adminsvc.repository.*;
import sgptt.adminsvc.request.RegisterRequest;

@Service
public class RegisterService {

    private final AcademyRepository academyRepository;
    private final PersonRepository personRepository;

    @Autowired
    public RegisterService(AcademyRepository academyRepository, PersonRepository personRepository) {
        this.academyRepository = academyRepository;
        this.personRepository = personRepository;
    }

    public void insertNewUser(RegisterRequest registerRequest) {
        personRepository.save(PersonMapper.map(registerRequest.getPerson(), registerRequest.getEmail(), personRepository.crypt(registerRequest.getPassword()), academyRepository));
    }
}
