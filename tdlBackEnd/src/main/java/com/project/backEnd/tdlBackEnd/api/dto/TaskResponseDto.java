package com.project.backEnd.tdlBackEnd.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
public class TaskResponseDto {
    public UUID id;
    public String taskName;
    @Builder.Default
    public String priority = "low";
    public boolean completed;
}
