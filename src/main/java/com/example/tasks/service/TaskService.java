package com.example.tasks.service;

import com.example.tasks.dto.TaskRequest;
import com.example.tasks.model.Task;
import com.example.tasks.repository.InMemoryTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final InMemoryTaskRepository repository;

    public TaskService(InMemoryTaskRepository repository) {
        this.repository = repository;
        // seed with sample data for demo
        Task t1 = new Task("Comprar mantimentos", "Leite, pão, ovos");
        repository.save(t1);
        Task t2 = new Task("Estudar", "Rever conceitos de Spring Boot");
        repository.save(t2);
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
        Optional<Task> existing = repository.findById(id);
        if (existing.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
