package com.project.backEnd.tdlBackEnd.controllers;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.TaskRequests.TaskRequest;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import com.project.backEnd.tdlBackEnd.api.services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class new_controller {
    private final TaskService taskService;

    public new_controller(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public TaskEntity createTask(
            @RequestBody TaskEntity taskRequest
    ){
       return taskService.createTask(taskRequest);
   }
}
