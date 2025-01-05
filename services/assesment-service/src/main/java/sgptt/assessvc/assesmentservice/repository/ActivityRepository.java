package sgptt.assessvc.assesmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
