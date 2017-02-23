package com.jikan.controllers;

import com.jikan.models.User;
import com.jikan.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by V-Rod on 2/17/17.
 */
@Controller
public class AuthenticationController {

    private PasswordEncoder encoder;
    private UsersRepository repository;

    @Autowired
    public AuthenticationController(UsersRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showForm(Model viewModel) {
        viewModel.addAttribute("user", new User());
        return "users/create";
    }

    @PostMapping("users/create")
    public String registerUser(
            @Valid User user,
            Errors validation,
            Model viewModel,
            @RequestParam(name = "password_confirm") String passwordConfirmation
    ){
        if (!passwordConfirmation.equals(user.getPassword())) {
            validation.rejectValue(
                    "password",
                    "user.password",
                    "Your passwords do not match!"
            );
        }

        if (validation.hasErrors()) {
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("user", user);
            return "users/create";
        }

        String hashedPassword = encoder.encode(user.getPassword()); // hash the users password
        user.setPassword(hashedPassword);

        User newUser = new User(repository.save(user));  // save the user to the database

        viewModel.addAttribute("user", newUser);
        return "redirect:/login";  // redirect the user to the login page
    }
}
