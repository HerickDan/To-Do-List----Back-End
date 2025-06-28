package com.project.backEnd.tdlBackEnd.controllers;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import com.project.backEnd.tdlBackEnd.api.services.TaskService;
import org.springframework.web.bind.annotation.*;

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
        return  taskService.createTask(task);
    }

    @GetMapping("/getTaskById/{id}")
    public TaskDto getTaskById(
            @PathVariable UUID id
    ){
        return taskService.getTaskById(id);
    }
}