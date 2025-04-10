package dev.rokasrozga.dts_developer_challenge.controller;

import dev.rokasrozga.dts_developer_challenge.model.Task;
import dev.rokasrozga.dts_developer_challenge.model.TaskStatus;
import dev.rokasrozga.dts_developer_challenge.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }

    @PatchMapping("/{id}/status")
    public Task updateTaskStatus(@PathVariable Long id,
                                 @RequestBody TaskStatus status) {
        return taskService.updateTaskStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
