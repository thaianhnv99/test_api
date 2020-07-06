package example.demo.Repository;

import example.demo.Entity.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface departmentRepository extends JpaRepository<department, Integer> {
    @Query(value = "select * from department d where d.id = :p_id", nativeQuery = true)
    department findById(@Param("p_id") int p_id);
}
