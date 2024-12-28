package sgptt.adminsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgptt.adminsvc.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
