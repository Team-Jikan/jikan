package com.jikan.repositories;

import com.jikan.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by V-Rod on 2/17/17.
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

    public User findById(Integer id);

}
