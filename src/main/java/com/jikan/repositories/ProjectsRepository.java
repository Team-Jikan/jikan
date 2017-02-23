package com.jikan.repositories;

import com.jikan.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by V-Rod on 2/23/17.
 */
@Repository
public interface ProjectsRepository extends CrudRepository<Project, Integer>{

    public Project findById(Integer id);


}
