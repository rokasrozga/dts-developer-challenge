package dev.rokasrozga.dts_developer_challenge.service;

import dev.rokasrozga.dts_developer_challenge.model.Task;
import dev.rokasrozga.dts_developer_challenge.model.TaskStatus;
import dev.rokasrozga.dts_developer_challenge.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Task getTask(Long id) {
        try {
            return repository.getReferenceById(id);
        } catch (EntityNotFoundException notFoundException) {
            throw new EntityNotFoundException("Task with ID " + id + "not found");
        }
    }

    public List<Task> getAllTask(){
        return repository.findAll();
    }

    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task task = getTask(id);
        task.setStatus(status);
        return repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
