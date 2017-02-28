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

    @Column(nullable = true)
    private Time starttime;

    @Column(nullable = false)
    private Date enddate;

    @Column(nullable = true)
    private Time endtime;

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
        this.starttime = starttime;
        this.enddate = enddate;
        this.endtime = endtime;
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

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
