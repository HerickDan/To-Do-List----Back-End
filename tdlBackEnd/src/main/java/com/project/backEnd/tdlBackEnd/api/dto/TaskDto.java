package com.project.backEnd.tdlBackEnd.api.dto;

import com.project.backEnd.tdlBackEnd.Entity.TaskEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {
    public String taskName;
    @Builder.Default
    public String priority = "low";
    public boolean completed;
}
