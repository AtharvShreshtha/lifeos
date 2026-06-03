package com.lifeos.lifeos;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    private final TaskRepository taskRepository;
    private final GoalRepository goalRepository;

    public TaskController (TaskRepository taskRepository, GoalRepository goalRepository){
        this.taskRepository = taskRepository;
        this.goalRepository = goalRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask (@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PatchMapping("/{id}/status")
    public Task upateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(updatedTask.getStatus());
        return taskRepository.save(task);
    }
}
