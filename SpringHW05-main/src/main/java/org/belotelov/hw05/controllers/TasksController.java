package org.belotelov.hw05.controllers;

import lombok.AllArgsConstructor;
import org.belotelov.hw05.model.Status;
import org.belotelov.hw05.model.Task;
import org.belotelov.hw05.repository.TasksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class TasksController {
    private TasksRepository tasksRepository;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! This is notes application";
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return tasksRepository.findAll();
    }

    @PostMapping()
    public Task addTask(@RequestBody Task task) {
        return tasksRepository.save(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Status status) {
        return tasksRepository.findByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
        Task current = tasksRepository.findById(id).orElse(null);
        if (current != null) {
            int currentStatusNumber = current.getStatus().ordinal();
            if (current.getStatus() != Status.COMPLETED) {
                currentStatusNumber++;
                current.setStatus(Status.values()[currentStatusNumber]);
            }
        }
        return tasksRepository.save(current);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasksRepository.deleteById(id);
    }
}
