package com.example.tasks.repository;

import com.example.tasks.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class FileTaskRepository implements TaskRepository {

    private final ObjectMapper mapper;
    private final File file = new File("src/main/resources/data/tasks.json");
    private List<Task> tasks = new ArrayList<>();

    // Injete o ObjectMapper configurado pelo Spring
    public FileTaskRepository(ObjectMapper mapper) {
        this.mapper = mapper;
        load();
    }

    private void load() {
        try {
            if (file.exists()) {
                tasks = mapper.readValue(file, new TypeReference<List<Task>>() {});
            } else {
                save();
            }
        } catch (IOException e) {
            tasks = new ArrayList<>();
        }
    }

    private void save() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, tasks);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar tarefas.", e);
        }
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Optional<Task> findById(String id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    @Override
    public Task save(Task task) {
        findById(task.getId()).ifPresent(tasks::remove);
        tasks.add(task);
        save();
        return task;
    }

    @Override
    public boolean delete(String id) {
        boolean removed = tasks.removeIf(t -> t.getId().equals(id));
        if (removed) save();
        return removed;
    }
}
