package com.example.tasks.service;

import com.example.tasks.dto.TaskRequest;
import com.example.tasks.model.Task;
import com.example.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> all() {
        return repository.findAll();
    }

    public Optional<Task> getById(String id) {
        return repository.findById(id);
    }

    public Task create(TaskRequest req) {
        Task t = new Task(req.getTitle(), req.getDescription());
        return repository.save(t);
    }

    public Optional<Task> update(String id, TaskRequest req) {
        Optional<Task> existing = repository.findById(id);

        if (existing.isPresent()) {
            Task t = existing.get();
            t.setTitle(req.getTitle());
            t.setDescription(req.getDescription());
            repository.save(t);
            return Optional.of(t);
        }

        return Optional.empty();
    }

    public boolean delete(String id) {
        return repository.delete(id);
    }
}
