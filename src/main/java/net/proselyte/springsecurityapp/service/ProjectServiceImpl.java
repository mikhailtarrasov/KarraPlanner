package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.ProjectDao;
import net.proselyte.springsecurityapp.model.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Михаил on 25.09.2016.
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
    private ProjectDao projectDao;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }


    @Override
    @Transactional
    public void addProject(Project project) {
        this.projectDao.addProject(project);
    }

    @Override
    @Transactional
    public void updateProject(Project project) {
        this.projectDao.updateProject(project);
    }

    @Override
    @Transactional
    public void removeProject(Long id) {
        this.projectDao.removeProject(id);
    }

    @Override
    @Transactional
    public Project getProjectById(Long id) {
        return this.projectDao.getProjectById(id);
    }

    @Override
    @Transactional
    public List<Project> listProjects() {
        return this.projectDao.listProjects();
    }
}
