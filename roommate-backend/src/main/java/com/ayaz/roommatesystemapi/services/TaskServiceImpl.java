package com.ayaz.roommatesystemapi.services;

import com.ayaz.roommatesystemapi.entity.TaskEntity;
import com.ayaz.roommatesystemapi.entity.UserEntity;
import com.ayaz.roommatesystemapi.model.Task;
import com.ayaz.roommatesystemapi.model.User;
import com.ayaz.roommatesystemapi.repository.TaskRepository;
import com.ayaz.roommatesystemapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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

}
