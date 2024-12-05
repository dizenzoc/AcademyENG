package eng.corso.it.taskservice.service;

import eng.corso.it.taskservice.model.Task;

import java.util.List;

public interface TaskService {

    Task save(Task task);

    Task update(Long id, Task task);

    void delete(Long id);

    Task findById(Long id);

    List<Task> findAll();

    List<Task> findByCompleted(Boolean completed);
}
