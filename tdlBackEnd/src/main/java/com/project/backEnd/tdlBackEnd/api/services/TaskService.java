package com.project.backEnd.tdlBackEnd.api.services;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import com.project.backEnd.tdlBackEnd.api.dto.TaskResponseDto;
import com.project.backEnd.tdlBackEnd.api.repositories.ITaskRepository;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Builder
@Service
public class TaskService {

    private final ITaskRepository taskRepository;

    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity createTask(TaskDto taskDto) {
        TaskEntity entity = TaskEntity.builder()
                .taskName(taskDto.taskName)
                .priority(taskDto.priority)
                .completed(taskDto.completed)
                .build();

        TaskEntity savedTask = taskRepository.save(entity);

        return savedTask;
    }

    public TaskEntity getTaskByTitle(String title) {
        TaskEntity getedTask = taskRepository.getTaskByTaskName(title);
        return TaskEntity.builder()
                .taskName(getedTask.taskName)
                .completed(getedTask.completed)
                .build();
    }

    public List<TaskResponseDto> getAllTasks() {
        List<TaskEntity> tasksList = taskRepository.findAll();
        List<TaskResponseDto> convetToDto = tasksList.stream().map(it ->
                TaskResponseDto.builder()
                        .id(it.id)
                        .taskName(it.taskName)
                        .completed(it.completed)
                        .priority(it.priority)
                        .build()).collect(Collectors.toList());

        return convetToDto;
    }

    public void deleteTask(String title) {
        TaskEntity getedTask = taskRepository.getTaskByTaskName(title);

        taskRepository.deleteById(getedTask.id);
    }

    public TaskEntity completeTask(String id) {
        UUID idConverter = UUID.fromString(id);

        TaskEntity getedTask = taskRepository.getTaskById(idConverter);

        TaskEntity updatedTask = taskRepository.save(getedTask.toBuilder().completed(true).build());

        return updatedTask;
    }

    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }

}
