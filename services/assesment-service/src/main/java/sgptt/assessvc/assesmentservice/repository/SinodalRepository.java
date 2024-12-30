package sgptt.assessvc.assesmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.Professor;
import sgptt.assessvc.assesmentservice.entity.Protocol;
import sgptt.assessvc.assesmentservice.entity.Sinodal;

import java.util.Optional;

@Repository
public interface SinodalRepository extends JpaRepository<Sinodal, Long> {

    Sinodal findByProfessorAndProtocol(Professor professor, Protocol protocol);

}
