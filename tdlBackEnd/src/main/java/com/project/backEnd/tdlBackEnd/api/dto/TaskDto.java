package com.project.backEnd.tdlBackEnd.api.dto;

import java.util.UUID;


public class TaskDto {
    private String id = UUID.randomUUID().toString();
    private String title;
    private boolean completed;

    public void toDto(String id, String title, boolean completed){

        this.title = title;
        this.completed = completed;
    }
}
