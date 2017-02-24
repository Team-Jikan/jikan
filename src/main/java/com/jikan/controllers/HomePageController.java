package com.jikan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by V-Rod on 2/24/17.
 */
@Controller
public class HomePageController {

    @GetMapping("/")
    public String homePage(){
        return "home";
    }


}
