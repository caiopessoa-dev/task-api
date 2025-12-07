package com.example.tasks.repository;

import com.example.tasks.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    List<Task> findAll();
    Optional<Task> findById(String id);
    Task save(Task task);
    boolean delete(String id);
}
