package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Task;

import java.util.List;

/**
 * Created by Михаил on 07.10.2016.
 */

public interface TaskService {
    public void addTask(Task task);

    public void updateTask(Task task);

    public void removeTask(Long ID);

    public Task getTaskById(Long ID);

    public List<Task> listTasks(Long id_proj);

}
