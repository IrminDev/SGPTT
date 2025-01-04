package sgptt.assessvc.assesmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.assessvc.assesmentservice.entity.Protocol;

@Repository
public interface ProtocolRespository extends JpaRepository<Protocol, Integer> {
}
