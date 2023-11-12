package com.emvalai.taskservice.controller;

import com.emvalai.taskservice.entities.TaskEntity;
import com.emvalai.taskservice.service.TaskService;
import com.emvalai.taskservice.entities.TaskUpdateRestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getTask(){
        return "Taskza555";
    }

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody TaskEntity task){
        TaskEntity taskEntity = taskService.addTask(task);
        return ResponseEntity.ok(taskEntity);
    }

    @GetMapping("/ByProjId/{projId}")
    public ResponseEntity<List<TaskEntity>> getTasksByprojectId(@PathVariable("projId") String projId){
        List<TaskEntity> entityList = taskService.getTasksByProjId(projId);
        return ResponseEntity.ok(entityList);
    }

    @PostMapping("/updateTask")
    public ResponseEntity<List<TaskEntity>> updateTask(@RequestBody TaskUpdateRestModel taskUpdateRestModel){
        List<TaskEntity> taskEntityList = taskService.UpdateTask(taskUpdateRestModel.getTaskEntityList());
        return ResponseEntity.ok(taskEntityList);
    }

    @GetMapping("delTask/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("taskId") String taskId){
        return ResponseEntity.ok(taskService.DelTask(taskId));

    }
}
