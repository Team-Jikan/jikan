package com.jikan.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by V-Rod on 2/22/17.
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double billablehours;

    @Column(nullable = false)
    @NotBlank(message = "Please enter a task description")
    private String tasks;

    @Column(nullable = false)
    private Date startdate;

    @Column(nullable = false)
    private Date enddate;

    @ManyToOne
    @JoinColumn(name = "projects_id")
    @JsonManagedReference
    private Project project;

    //-----------CONSTRUCTORS----------//

    public Task(
            double billablehours,
            String tasks,
            Date startdate,
            Time starttime,
            Date enddate,
            Time endtime,
            Project project) {
        this.billablehours = billablehours;
        this.tasks = tasks;
        this.startdate = startdate;
        this.enddate = enddate;
        this.project = project;
    }

    public Task() {

    }


    //-----------SETTERS & GETTERS-----------//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBillablehours() {
        return billablehours;
    }

    public void setBillablehours(double billablehours) {
        this.billablehours = billablehours;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
