package sgptt.assessvc.assesmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.Academy;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
}
