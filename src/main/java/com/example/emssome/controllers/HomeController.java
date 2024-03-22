package com.example.emssome.controllers;

import com.example.emssome.models.User;
import com.example.emssome.services.PostService;
import com.example.emssome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

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


    @GetMapping("/user/{username}")
    public String getUserPosts(@PathVariable String username, Model model) {
        User user = userService.findUserByUsername(username);
        model.addAttribute(userService);
        model.addAttribute(user);
        System.out.println(user.getProfilePicture());

        if (user != null) {
            model.addAttribute("posts", postService.getPostsByUserId(user.getUserId()));
            return "home/user";
        } else {
            return "home/user_not_found";
        }
    }


    @PostMapping("/add-post") // Update the mapping to match the form action
    public String insertNewPost(@RequestParam String postContent) {
        // Process the new post content

        // Simulates that empasquer is connected
        User user = userService.findUserById(2);

        LocalDateTime currentDate = LocalDateTime.now();
        postService.insertNewPost(user.getUserId(), postContent, currentDate);

        return "redirect:/";
    }


}
