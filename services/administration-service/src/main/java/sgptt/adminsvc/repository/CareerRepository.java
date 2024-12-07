package sgptt.adminsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.adminsvc.repository.entity.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
    Career findByName(String careerName);
}
