package ru.wca.swa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.wca.swa.model.Task;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(task);
    }

    @Override
    public void update(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(task);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = (Task) session.load(Task.class, id);

        if (task != null)
            session.delete(task);
    }

    @Override
    public Task get(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = (Task) session.load(Task.class, id);

        return task;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Task> listTasks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Task> taskList = session.createQuery("from Task").list();

        return taskList;
    }
}
