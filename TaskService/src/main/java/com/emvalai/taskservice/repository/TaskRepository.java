package com.emvalai.taskservice.repository;

import com.emvalai.taskservice.entities.TaskEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<TaskEntity, String> {

    @Query(value="{projectId:'?0'}")
    public List<TaskEntity> findByProjectId(String projId);
}
