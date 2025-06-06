package com.project.backEnd.tdlBackEnd.api.repositories;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<TaskEntity, String> {
    //  public void createTask()
}
