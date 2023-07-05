package com.ayaz.roommatesystemapi.services;

import com.ayaz.roommatesystemapi.entity.TaskEntity;
import com.ayaz.roommatesystemapi.entity.UserEntity;
import com.ayaz.roommatesystemapi.model.Task;
import com.ayaz.roommatesystemapi.model.User;
import com.ayaz.roommatesystemapi.repository.TaskRepository;
import com.ayaz.roommatesystemapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        TaskEntity taskEntity = new TaskEntity();

        BeanUtils.copyProperties(task, taskEntity);
        taskRepository.save(taskEntity);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        //Retrieves all tasks in database
        List<TaskEntity> taskEntities = taskRepository.findAll();
        List<Task> tasks = taskEntities
                .stream()
                .map(task -> new Task(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getResponsible(),
                        task.getDate()))
                .collect(Collectors.toList());
        return tasks;
    }

    @Override
    public Task getTaskById(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        Task task = new Task();
        BeanUtils.copyProperties(taskEntity, task);
        return task;
    }

}
