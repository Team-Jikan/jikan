package com.jikan.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by V-Rod on 2/21/17.
 */
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Project name cannot be empty")
    private String projectname;

    @Column(nullable = false)
    @NotBlank(message = "Customer cannot be empty")
    private String customer;

    @Column(nullable = false)
    @NotBlank(message = "Contact name cannot be empty")
    private String contactname;

    @Column(nullable = false)
    @NotBlank(message = "Contact email cannot be empty")
    private String contactemail;

    @Column(nullable = false)
    @NotBlank(message = "Contact phone number cannot be empty")
    private String contactphone;

    @Column(nullable = false)
    private Date startdate;

    @Column(nullable = false)
    private Date enddate;

    @Column(nullable = false)
    @NotBlank(message = "Please enter a project description")
    @Size(min = 5, message = "Description must be at least 5 characters long")
    private String projectdescription;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonManagedReference
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    @JsonBackReference
    List<Task> tasks;


    //-----------CONSTRUCTORS----------//

    public Project(
            String projectname,
            String customer,
            String contactname,
            String contactemail,
            String contactphone,
            Date startdate,
            Date enddate,
            User user)
    {
        this.projectname = projectname;
        this.customer = customer;
        this.contactname = contactname;
        this.contactemail = contactemail;
        this.contactphone = contactphone;
        this.startdate = startdate;
        this.enddate = enddate;
        this.user = user;
    }

    public Project() {

    }

    //-----------SETTERS & GETTERS-----------//


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
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

    public String getProjectdescription() {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription) {
        this.projectdescription = projectdescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
