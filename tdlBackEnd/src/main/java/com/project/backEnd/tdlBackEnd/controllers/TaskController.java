package com.project.backEnd.tdlBackEnd.controllers;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import com.project.backEnd.tdlBackEnd.api.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public TaskEntity createTask (@RequestBody TaskDto task) throws Exception {return taskService.createTask(task);}

    @GetMapping("/{title}")
    public TaskEntity getTaskByTitle(@PathVariable String title){
        return taskService.getTaskByTitle(title);
    }

    @DeleteMapping("/delete/{title}")
    public void deleteTask(@PathVariable String title){
        taskService.deleteTask(title);
    }

    @GetMapping("/getAll")
    public List<TaskEntity> getAllTasks(){return taskService.getAllTasks();}

    @PatchMapping("/update/{id}")
    public TaskEntity completeTask(
        @PathVariable String id
    ){
        return taskService.completeTask(id);
    }

    @DeleteMapping("/deleteAllTasks")
    public void deleteAllTasks(){
        taskService.deleteAllTasks();
    }
}