package com.emvalai.taskservice.entities;

import com.emvalai.taskservice.entities.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskUpdateRestModel {
//    private String projectId;
    private List<TaskEntity> taskEntityList;

}
