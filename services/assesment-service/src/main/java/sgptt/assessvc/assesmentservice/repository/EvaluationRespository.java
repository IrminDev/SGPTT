package sgptt.assessvc.assesmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.Evaluation;

@Repository
public interface EvaluationRespository extends JpaRepository<Evaluation, Long> {

}
