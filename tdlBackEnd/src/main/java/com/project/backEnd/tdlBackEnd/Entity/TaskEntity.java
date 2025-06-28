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
    private UUID id;

    @Column(nullable = false)
    public String title;

    public boolean completed;


}
