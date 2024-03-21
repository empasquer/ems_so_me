package com.example.emssome.controllers;

import com.example.emssome.services.PostService;
import com.example.emssome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postService.getPosts());
        model.addAttribute("userService", userService);
        return "home/index";
    }
}
