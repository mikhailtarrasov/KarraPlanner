package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.TaskDao;
import net.proselyte.springsecurityapp.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Михаил on 07.10.2016.
 */

@Service
public class TaskServiceImpl implements TaskService {
    private TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    @Transactional
    public void addTask(Task task) {
        this.taskDao.addTask(task);
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        this.taskDao.updateTask(task);
    }

    @Override
    @Transactional
    public void removeTask(Long ID) {
        this.taskDao.removeTask(ID);
    }

    @Override
    @Transactional
    public Task getTaskById(Long ID) {
        return this.taskDao.getTaskById(ID);
    }

    @Override
    @Transactional
    public List<Task> listTasks(Long id_proj) {return this.taskDao.listTasks(id_proj); }

}
