package sgptt.adminsvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sgptt.adminsvc.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select * from crypt(:password, gen_salt('md5'))", nativeQuery = true)
    String crypt(@Param("password") String password);
}
