package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Task;

import java.util.List;

/**
 * Created by Михаил on 06.10.2016.
 */
public interface TaskDao {
    public void addTask(Task task);

    public void updateTask(Task task);

    public void removeTask(Long IdTask);

    public Task getTaskById(Long IdTask);

    public List<Task> listTasks(Long id_proj);
}
