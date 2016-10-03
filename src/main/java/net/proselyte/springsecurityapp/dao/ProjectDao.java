package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Project;

import java.util.List;

public interface ProjectDao{
    public void addProject(Project project);

    public void updateProject(Project project);

    public void removeProject(Long id);

    public Project getProjectById(Long id);

    public List<Project> listProjects();
}
