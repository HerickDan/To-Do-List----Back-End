package com.project.backEnd.tdlBackEnd.api.services;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import com.project.backEnd.tdlBackEnd.api.repositories.ITaskRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;
import java.util.List;

@Builder
@Service
public class TaskService {

    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDto createTask(TaskDto taskDto) {
        TaskEntity entity = TaskEntity.builder()
                .taskName(taskDto.taskName)
                .priority(taskDto.priority)
                .completed(taskDto.completed)
                .build();
        TaskEntity saved = taskRepository.save(entity);
        TaskDto taskDto1 = TaskDto.builder()
                .taskName(saved.taskName).completed(saved.completed).build();
        return taskDto1;
    }

    public TaskEntity getTaskByTitle(String title) {
        TaskEntity getedTask = taskRepository.getTaskByTaskName(title);
        return TaskEntity.builder()
                .taskName(getedTask.taskName)
                .completed(getedTask.completed)
                .build();
    }

    public List<TaskEntity> getAllTasks(){
        List<TaskEntity> tasksList = taskRepository.findAll();
        return tasksList;
    }

    public void deleteTask(String title){
        TaskEntity getedTask = taskRepository.getTaskByTaskName(title);
        taskRepository.deleteById(getedTask.id);
    }
}
