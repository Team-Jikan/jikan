package com.jikan.security;

import com.jikan.models.Project;
import com.jikan.models.User;
import com.jikan.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by V-Rod on 3/1/17.
 */
@Service
public class ProjectOwnerExpression {
    private ProjectsRepository projects;

    @Autowired
    public ProjectOwnerExpression (ProjectsRepository projects) {
        this.projects = projects;
    }

    public boolean isOwner(User currentUser, int projectId) {
        Project project = projects.findById(projectId);
        User owner = project.getUser();
        return owner != null && owner.getId() == currentUser.getId();
    }
}
