package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.Project;

import java.util.List;

/**
 * Created by Михаил on 25.09.2016.
 */

public interface ProjectService {
    public void addProject(Project project);

    public void updateProject(Project project);

    public void removeProject(Long id);

    public Project getProjectById(Long id);

    public List<Project> listProjects();
}
