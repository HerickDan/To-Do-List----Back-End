package com.project.backEnd.tdlBackEnd.api.services;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.repositories.ITaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity createTask(TaskEntity task){
        return taskRepository.save(task);
    }
}
