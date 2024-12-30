package sgptt.assessvc.assesmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.CriterionEvaluation;

@Repository
public interface CriterionEvaluationRepository extends JpaRepository<CriterionEvaluation, Long> {
}
