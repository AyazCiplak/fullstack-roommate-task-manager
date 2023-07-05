package com.ayaz.roommatesystemapi.repository;

import com.ayaz.roommatesystemapi.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {}
