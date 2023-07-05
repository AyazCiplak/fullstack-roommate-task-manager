package com.ayaz.roommatesystemapi.services;


import com.ayaz.roommatesystemapi.model.Task;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
}
