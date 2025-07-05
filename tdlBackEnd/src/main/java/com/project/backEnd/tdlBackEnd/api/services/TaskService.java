package com.project.backEnd.tdlBackEnd.api.services;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import com.project.backEnd.tdlBackEnd.api.repositories.ITaskRepository;
import lombok.Builder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Builder
@Service
public class TaskService {

    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDto createTask(TaskDto taskDto) throws Exception {
        TaskEntity entity = TaskEntity.builder()
                .taskName(taskDto.taskName)
                .priority(taskDto.priority)
                .completed(taskDto.completed)
                .build();
        TaskEntity saved = taskRepository.save(entity);
        TaskDto taskDto1 = TaskDto.builder()
                .taskName(saved.taskName).completed(saved.completed).build();
        try {
            return taskDto1;
        } catch (DataIntegrityViolationException e) {
            throw new Exception("Task already exists", e);
        }
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
//
//    public TaskEntity updateTask(String id){
//        UUID idConverter = UUID.fromString(id);
//        TaskEntity getedTask = taskRepository.getTaskByTaskName(title);
//        return TaskEntity;
//    }
}
