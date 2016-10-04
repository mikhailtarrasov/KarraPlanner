package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class ProjectDaoImpl implements ProjectDao{
    private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProject(Project project) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.persist(project);
            logger.info("Project succsessfully saved. Project details: " + project);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при добавлении проекта", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


        /*Session session = this.sessionFactory.getCurrentSession();
        //session.beginTransaction();
        session.persist(project);
        //session.getTransaction().commit();
        logger.info("Project succsessfully saved. Project details: " + project);*/
    }

    @Override
    public void updateProject(Project project) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(project);

            logger.info("Project successfully update. Project details: " + project);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при обновлении проекта", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }




        /*Session session = this.sessionFactory.getCurrentSession();
        //session.beginTransaction();
        session.update(project);
        //session.getTransaction().commit();
        logger.info("Project successfully update. Project details: " + project);*/
    }

    @Override
    public void removeProject(Long id) {
        Session session = null;
        Transaction transaction = null;

        Project project = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            project = (Project) session.load(Project.class, new Long(id));

            if(project != null){
                session.delete(project);
            }

            logger.info("Project successfully delete. Project details: " + project);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении проекта", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }



        /*Session session = this.sessionFactory.getCurrentSession();
        //session.beginTransaction();
        Project project = (Project) session.load(Project.class, new Long(id));

        if(project != null){
            session.delete(project);
        }
        //session.getTransaction().commit();
        logger.info("Project successfully delete. Project details: " + project);*/
    }

    @Override
    public Project getProjectById(Long id) {
        Session session = null;
        Transaction transaction = null;
        Project project = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            project = (Project) session.load(Project.class, new Long(id));

            logger.info("Project successfully loaded. Project details: " + project);

            transaction.commit();

            return project;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при получении идентификатора", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }




       /* Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Project project = (Project) session.load(Project.class, new Long(id));

        //session.getTransaction().commit();
        logger.info("Project successfully loaded. Project details: " + project);*/

        return project;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Project> listProjects() {
        Session session = null;
        Transaction transaction = null;
        List<Project> projectList = null;

        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            projectList = session.createQuery("from Project").list();
            for(Project project: projectList){
                logger.info("Project list: " + project);
            }

            transaction.commit();

            return projectList;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при составлении списка проектов", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
/*
        this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Project> projectList = session.createQuery("from Project").list();
        for(Project project: projectList){
            logger.info("Project list: " + project);
        }
        session.getTransaction().commit();*/
        return projectList;
    }
}
