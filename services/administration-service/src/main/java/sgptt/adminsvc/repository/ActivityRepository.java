package sgptt.adminsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.adminsvc.repository.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
