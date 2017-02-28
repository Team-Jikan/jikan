package com.jikan.repositories;

import com.jikan.models.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by V-Rod on 2/27/17.
 */
@Repository
public interface TasksRepository extends CrudRepository<Task, Integer>{

    // create a method that will return a List of tasks and will receive the project id
    //use a query annotation for this
    //Select from tasks where taks.project.id = {id}

    @Query("select t from Task t where t.project.id = ?1")
    public List<Task> addedTasksForProject(int id);

}
