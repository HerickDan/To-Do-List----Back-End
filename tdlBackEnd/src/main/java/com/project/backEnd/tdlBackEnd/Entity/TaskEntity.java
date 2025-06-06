package com.project.backEnd.tdlBackEnd.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "tasks")
@Entity
public class TaskEntity {
    @Id
    private String id = UUID.randomUUID().toString();

    private String title;
    private boolean completed;
}
