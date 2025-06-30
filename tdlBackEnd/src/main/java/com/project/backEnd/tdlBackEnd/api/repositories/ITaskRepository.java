package com.project.backEnd.tdlBackEnd.api.repositories;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;
@EnableJpaRepositories
public interface ITaskRepository extends JpaRepository<TaskEntity, UUID> {
    TaskEntity getTaskByTitle(String title);
    void deleteById(UUID id);
}
