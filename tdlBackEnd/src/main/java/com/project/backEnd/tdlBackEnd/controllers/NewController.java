package com.project.backEnd.tdlBackEnd.controllers;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NewController {

    private final TaskService taskService;

    public NewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        System.out.println("Título recebido: ");
        return taskService.createTask(task);
    }
}