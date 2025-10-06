package com.example.app.service;

import com.example.app.model.Task;
import com.example.app.repo.TaskRepository;
import com.example.app.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) { this.repo = repo; }

    @Override public List<Task> findAll() { return repo.findAll(); }

    @Override public Task findById(Long id) {
        return repo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Task " + id + " not found"));
    }

    @Override public Task create(Task t) { t.setId(null); return repo.save(t); }

    @Override public Task update(Long id, Task t) {
        Task existing = findById(id);
        existing.setTitle(t.getTitle());
        existing.setDescription(t.getDescription());
        existing.setCompleted(t.isCompleted());
        return repo.save(existing);
    }

    @Override public void delete(Long id) { repo.deleteById(id); }
}
