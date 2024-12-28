package sgptt.adminsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.adminsvc.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
