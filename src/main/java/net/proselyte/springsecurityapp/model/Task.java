package net.proselyte.springsecurityapp.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Михаил on 06.10.2016.
 */

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdTask;

    @Column(name = "id_project")
    private Long id_project;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "id_status")
    private Long id_status;

    public Long getID() {
        return IdTask;
    }

    public void setID(Long ID) {
        this.IdTask = IdTask;
    }

    public Long getId_project() {
        return id_project;
    }

    public void setId_project(Long id_project) {
        this.id_project = id_project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID=" + IdTask +
                ", id_project=" + id_project +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", id_status=" + id_status +
                '}';
    }



}