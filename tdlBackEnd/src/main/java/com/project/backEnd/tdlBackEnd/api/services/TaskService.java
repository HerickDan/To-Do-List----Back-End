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
                .title(taskDto.title)
                .completed(taskDto.completed)
                .build();
        TaskEntity saved = taskRepository.save(entity);
        TaskDto taskDto1 = TaskDto.builder()
                .title(saved.title).completed(saved.completed).build();
        return taskDto1;
    }

    public TaskEntity getTaskByTitle(String title) {
        TaskEntity getedTask = taskRepository.getTaskByTitle(title);
        return TaskEntity.builder()
                .title(getedTask.title)
                .completed(getedTask.completed)
                .build();
    }

    public List<TaskEntity> getAllTasks(){
        List<TaskEntity> tasksList = taskRepository.findAll();
        return tasksList;
    }

    public void deleteTask(String title){
        TaskEntity getedTask = taskRepository.getTaskByTitle(title);
        taskRepository.deleteById(getedTask.id);
    }
}
