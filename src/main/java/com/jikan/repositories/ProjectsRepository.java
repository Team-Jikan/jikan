package com.jikan.repositories;

import com.jikan.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by V-Rod on 2/23/17.
 */
@Repository
public interface ProjectsRepository extends CrudRepository<Project, Integer>{

    public Project findById(Integer id);

    @Query("select p from Project p where p.user.id=?1")
    public List<Project> findByUser(int userId);


}
