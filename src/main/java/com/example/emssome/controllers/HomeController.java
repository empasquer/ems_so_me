package com.example.emssome.controllers;

import com.example.emssome.models.Post;
import com.example.emssome.models.User;
import com.example.emssome.services.PostService;
import com.example.emssome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

/*
        // Debug statement to check if user is found
        int userIdToCheck = 1; // Change to the actual userId being used in your posts
        User user = userService.findUserById(userIdToCheck);
        if (user != null) {
            System.out.println("User found: " + user.getUsername());
        } else {
            System.out.println("User not found for userId: " + userIdToCheck);
        }
*/

        return "home/index";
    }



    @GetMapping("/user/{username}")
    public String getUserPosts(@PathVariable String username, Model model) {
        User user = userService.findUserByUsername(username);

        if (user != null) {
            model.addAttribute("posts", postService.getPostsByUserId(user.getUserId()));
            return "home/index";
        } else {
            return "user_not_found";
        }
    }


}
