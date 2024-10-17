package dio.to_do.controller;

import dio.to_do.domain.model.TaskList;
import dio.to_do.service.TaskListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskListController {
    private final TaskListService taskListService;
    public TaskListController(TaskListService taskListService){
        this.taskListService = taskListService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskList> findById(@PathVariable Integer id){
        TaskList tl = taskListService.findById(id);
        return ResponseEntity.ok(tl);
    }

    @PostMapping
    public ResponseEntity<TaskList> create(@RequestBody TaskList tlToCreate){
        var tlCreated = taskListService.create(tlToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tlCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(tlCreated);
    }
}
