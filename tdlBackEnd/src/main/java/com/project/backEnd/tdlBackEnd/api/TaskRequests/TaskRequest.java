package com.project.backEnd.tdlBackEnd.api.TaskRequests;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;

import java.util.UUID;


public class TaskRequest {
    private String id = UUID.randomUUID().toString();
    private String title;
    private boolean completed;
}
