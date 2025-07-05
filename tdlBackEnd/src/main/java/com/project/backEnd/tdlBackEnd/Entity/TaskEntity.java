package com.project.backEnd.tdlBackEnd.Entity;

import com.project.backEnd.tdlBackEnd.api.dto.TaskDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(nullable = false, unique = true)
    public String taskName;

    public boolean completed;

    public String priority;

}
