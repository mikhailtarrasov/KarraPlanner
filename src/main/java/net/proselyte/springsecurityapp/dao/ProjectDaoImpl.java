package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao{
    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(project);
        session.getTransaction().commit();
        logger.info("Project succsessfully saved. Project details: " + project);
    }

    @Override
    public void updateProject(Project project) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(project);
        session.getTransaction().commit();
        logger.info("Project successfully update. Project details: " + project);
    }

    @Override
    public void removeProject(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Project project = (Project) session.load(Project.class, new Long(id));

        if(project != null){
            session.delete(project);
        }
        session.getTransaction().commit();
        logger.info("Project successfully delete. Project details: " + project);
    }

    @Override
    public Project getProjectById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Project project = (Project) session.load(Project.class, new Long(id));

        session.getTransaction().commit();
        logger.info("Project successfully loaded. Project details: " + project);

        return project;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> listProjects() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Project> projectList = session.createQuery("from Project").list();
        for(Project project: projectList){
            logger.info("Project list: " + project);
        }
        session.getTransaction().commit();
        return projectList;
    }
}
