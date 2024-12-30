package sgptt.assessvc.assesmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
