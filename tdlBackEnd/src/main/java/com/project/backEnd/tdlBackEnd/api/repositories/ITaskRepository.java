package com.project.backEnd.tdlBackEnd.api.repositories;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITaskRepository extends JpaRepository<TaskEntity, UUID> {
    TaskEntity getTaskById(UUID id);
}
