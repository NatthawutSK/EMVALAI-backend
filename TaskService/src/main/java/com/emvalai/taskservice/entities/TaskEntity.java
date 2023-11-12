package com.emvalai.taskservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task")
public class TaskEntity {
    @Id
    private String _id;

    private String taskName;
    private String taskDesc;
    private String projectId;
    private TaskStatus taskStatus;
    private String userId;
    private String userName;
    private String dueDate;
    private String createdDate;

}
