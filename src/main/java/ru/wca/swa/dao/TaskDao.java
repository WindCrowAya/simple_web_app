package ru.wca.swa.dao;

import ru.wca.swa.model.Task;

import java.util.List;

public interface TaskDao {
    void add(Task task);
    void update(Task task);
    void remove(int id);
    Task get(int id);
    List<Task> listTasks();
}
