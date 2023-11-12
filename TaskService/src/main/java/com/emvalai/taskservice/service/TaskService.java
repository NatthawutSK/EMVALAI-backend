package com.emvalai.taskservice.service;

import com.emvalai.taskservice.entities.TaskEntity;
import com.emvalai.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity addTask(TaskEntity task){
       return taskRepository.save(task);
    }

    public List<TaskEntity> getTasksByProjId(String projId){
        return taskRepository.findByProjectId(projId);
    }

    public List<TaskEntity> UpdateTask(List<TaskEntity> taskEntityList){
        return taskRepository.saveAll(taskEntityList);
    }

    public Boolean DelTask(String taskId){
        taskRepository.deleteById(taskId);
        return true;

    }


}
