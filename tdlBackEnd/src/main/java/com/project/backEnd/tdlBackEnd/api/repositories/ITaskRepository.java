package com.project.backEnd.tdlBackEnd.api.repositories;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.UUID;
public interface ITaskRepository extends JpaRepository<TaskEntity, UUID> {
    TaskEntity getTaskByTaskName(String title);
    void deleteById(UUID id);
    void deleteAll();
    List<TaskEntity> findAll();
    TaskEntity getTaskById(UUID id);
}