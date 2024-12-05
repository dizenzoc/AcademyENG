package eng.corso.it.taskservice.controller;

import eng.corso.it.taskservice.model.Task;
import eng.corso.it.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task save( @RequestBody Task task ){
        return taskService.save( task );
    }

    @PutMapping("/{id}")
    public Task update( @PathVariable Long id, @RequestBody Task task ){
        return taskService.update( id, task );
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable Long id ){
        taskService.delete( id );
    }

    @GetMapping("/{id}")
    public Task findById( @PathVariable Long id ){
        return taskService.findById( id );
    }

    @GetMapping
    public List<Task> findAll( ){
        return taskService.findAll();
    }

    @GetMapping("/completed/{completed}")
    public List<Task> findByCompleted(@PathVariable String completed ){
        Boolean isCompleted = Boolean.parseBoolean(completed);
        return taskService.findByCompleted( isCompleted );
    }

}
