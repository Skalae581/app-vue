package com.example.app.service;

import com.example.app.model.Task;
import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(Long id);
    Task create(Task t);
    Task update(Long id, Task t);
    void delete(Long id);
}
