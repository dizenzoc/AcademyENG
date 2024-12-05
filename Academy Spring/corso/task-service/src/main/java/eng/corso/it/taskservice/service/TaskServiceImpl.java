package eng.corso.it.taskservice.service;

import eng.corso.it.taskservice.exception.NoDataFoundException;
import eng.corso.it.taskservice.model.Task;
import eng.corso.it.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save( task );
    }

    @Override
    public Task update(Long id, Task task) {
        return null;
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById( id );
    }

//    @Override
//    public Task findById(Long id) {
//        Optional<Task> task = taskRepository.findById(id);
//        if (task.isPresent()) {
//            return task.get();
//        } else {
//            throw new RuntimeException();
//        }
//    }

    @Override
    public Task findById(Long id) {
       return taskRepository.findById(id)
                .orElseThrow(NoDataFoundException::new);
    }


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByCompleted(Boolean completed) {
        return taskRepository.findByCompleted(completed);
    }
}
