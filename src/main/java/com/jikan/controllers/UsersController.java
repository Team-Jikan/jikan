package com.jikan.controllers;

import com.jikan.models.User;
import com.jikan.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by V-Rod on 2/23/17.
 */
@Controller
public class UsersController {

    @Autowired
    UsersRepository usersDao;

    @GetMapping("users/{id}")
    public String showUser(@PathVariable Integer id, Model viewModel) {
        User user = usersDao.findById(id);
        viewModel.addAttribute("user", user);
        return "users/show";

    }

}