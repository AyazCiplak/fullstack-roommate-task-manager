package com.ayaz.roommatesystemapi.controller;

import com.ayaz.roommatesystemapi.model.Task;
import com.ayaz.roommatesystemapi.model.User;
import com.ayaz.roommatesystemapi.services.TaskService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

  @PostMapping("/tasks")
  public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

}
