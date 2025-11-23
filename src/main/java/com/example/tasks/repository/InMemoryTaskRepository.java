package com.example.tasks.repository;

import com.example.tasks.model.Task;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryTaskRepository {

    private final Map<String, Task> storage = new LinkedHashMap<>();

    public List<Task> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Task> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Task save(Task task) {
        if (task.getId() == null || task.getId().isBlank()) {
            // generate new id
            // but Task constructor already sets id
        }
        storage.put(task.getId(), task);
        return task;
    }

    public void deleteById(String id) {
        storage.remove(id);
    }

    public void clear() {
        storage.clear();
    }
}
