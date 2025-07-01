package com.project.backEnd.tdlBackEnd.controllers;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.TaskRequests.GetTaskRequest;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import com.project.backEnd.tdlBackEnd.api.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class NewController {
    private final TaskService taskService;

    public NewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @CrossOrigin(origins = "*")

    @PostMapping("/createTask")
    public TaskDto createTask(
            @RequestBody TaskDto task) {
        System.out.println("Título recebido: ");
        return taskService.createTask(task);
    }

    @GetMapping("/{title}")
    public TaskEntity getTaskByTitle(
            @PathVariable String title
    ) {
        return taskService.getTaskByTitle(title);
    }

    @DeleteMapping("/delete/{title}")
    public void deleteTask(
            @PathVariable String title
    ){
        taskService.deleteTask(title);
    }

    @GetMapping("/getAll")
    public List<TaskEntity> getAllTasks(

    ){
        return taskService.getAllTasks();
    }
}