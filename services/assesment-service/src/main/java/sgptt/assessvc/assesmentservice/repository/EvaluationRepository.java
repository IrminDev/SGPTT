package sgptt.assessvc.assesmentservice.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.Evaluation;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findEvaluationBySinodal_ProtocolProtocolId(Long protocolId);

    List<Evaluation> findEvaluationsBySinodal_ProfessorPersonId(Long personId);

    @Transactional
    void deleteEvaluationsBySinodal_ProtocolProtocolId(Long protocolId);

}
