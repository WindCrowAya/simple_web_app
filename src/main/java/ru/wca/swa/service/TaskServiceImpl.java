package ru.wca.swa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.wca.swa.dao.TaskDao;
import ru.wca.swa.model.Task;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    @Transactional
    public void add(Task task) {
        this.taskDao.add(task);
    }

    @Override
    @Transactional
    public void update(Task task) {
        this.taskDao.update(task);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.taskDao.remove(id);
    }

    @Override
    @Transactional
    public Task get(int id) {
        return this.taskDao.get(id);
    }

    @Override
    @Transactional
    public List<Task> listTasks() {
        return this.taskDao.listTasks();
    }
}
