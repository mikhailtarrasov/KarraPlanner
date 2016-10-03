package net.proselyte.springsecurityapp.model;

import java.sql.Date;
import javax.persistence.*;


/**
 * Created by Михаил on 25.09.2016.
 */

@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadline;

    @Column(name = "id_creator")
    private Long id_creator;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public Long getId_creator() {
        return id_creator;
    }

    public void setId_creator(Long id_creator) {
        this.id_creator = id_creator;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", id_creator=" + id_creator +
                '}';
    }
}
