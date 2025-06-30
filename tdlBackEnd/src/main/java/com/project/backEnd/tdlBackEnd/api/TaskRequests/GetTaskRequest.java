package com.project.backEnd.tdlBackEnd.api.TaskRequests;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTaskRequest {
    public String taskTitle;
}
