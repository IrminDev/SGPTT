package sgptt.adminsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.adminsvc.repository.entity.Academy;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
    Academy findByName(String name);
}
