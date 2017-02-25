package com.jikan.controllers;

import com.jikan.models.Project;
import com.jikan.repositories.ProjectsRepository;
import com.jikan.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

/**
 * Created by V-Rod on 2/23/17.
 */
@Controller
public class ProjectsController {

    @Autowired
    ProjectsRepository projectDao;

    @Autowired
    UserService userService;

    @GetMapping("/projects")
    public String viewAllProjects (Model viewModel) {

        viewModel.addAttribute("projects", Collections.emptyList());

        return "projects/index";
    }

    @GetMapping("/projects.json")
    public @ResponseBody List<Project> retrieveAllProjects() {
        return (List<Project>) projectDao.findAll();
    }

    @GetMapping("/projects/{id}")
    public String viewSingleProject (@PathVariable int id, Model viewModel) {

        viewModel.addAttribute("project", projectDao.findOne(id));

        return "projects/show";
    }

    @GetMapping("/projects/create")
    public String viewCreatePostForm (@ModelAttribute Project project, Model viewModel) {
        viewModel.addAttribute("project", project);
        return "projects/create";
    }

    @PostMapping("projects/create")
    public String createProject (
            @Valid Project project,
            Errors validation,
            Model viewModel
    ){
        // if there are errors on validation, the viewModel will take you back to the form
        if (validation.hasErrors()){
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("project", project);
            return "projects/create";
        }

        project.setUser(userService.loggedInUser());
        projectDao.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}/edit")
    public String editProject(@PathVariable int id, @ModelAttribute Project project, Model viewModel) {
        Project editedProject = projectDao.findOne(id);
        viewModel.addAttribute("project", editedProject);
        return "/projects/edit";
    }

    @PostMapping("/projects/{id}/edit")
    public String updateProject (@Valid Project editedProject, Errors validation, Model viewModel) {

        if (validation.hasErrors()){
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("project", editedProject);
            return "projects/edit";
        }

        projectDao.save(editedProject);
        return "redirect:/projects";
    }

}
