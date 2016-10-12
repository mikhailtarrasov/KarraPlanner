package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Task;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

/**
 * Created by Михаил on 06.10.2016.
 */

@Repository
public class TaskDaoImpl implements TaskDao {
    private static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTask(Task task) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(task);

            logger.info("Task succsessfully saved. Task details: " + task);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении задачи", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateTask(Task task) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(task);

            logger.info("Task successfully update. Task details: " + task);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при обновлении задачи", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void removeTask(Long IdTask) {
        Session session = null;
        Transaction transaction = null;

        Task task = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            task = (Task) session.load(Task.class, new Long(IdTask));

            if(task != null){
                session.delete(task);
            }

            logger.info("Task successfully delete. Task details: " + task);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении задачи", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Task getTaskById(Long IdTask) {
        Session session = null;
        Transaction transaction = null;

        Task task = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            task = (Task) session.load(Task.class, new Long(IdTask));

            logger.info("Task successfully loaded. Task details: " + task);

            transaction.commit();

            return task;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при получении идентификатора", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return task;
    }

    @Override
    public List<Task> listTasks(Long id_proj) {
        Session session = null;
        Transaction transaction = null;
        List<Task> taskList = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Task where id_project=:param");
            query.setParameter("param", id_proj);
            taskList = query.list();

            for(Task task: taskList){
                logger.info("Task list: " + task);
            }

            transaction.commit();

            return taskList;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при составлении списка задач", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return taskList;
    }
}
