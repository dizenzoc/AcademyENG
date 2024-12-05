package eng.corso.it.taskservice.repository;


import eng.corso.it.taskservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "select * from task t where t.completed = ?1", nativeQuery = true)
    List<Task> findByCompleted(Boolean completed);

}
