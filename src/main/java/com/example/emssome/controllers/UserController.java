package com.example.emssome.controllers;

import com.example.emssome.models.User;
import com.example.emssome.services.UserService;
import com.mysql.cj.jdbc.Blob;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    UserService userService;



    @GetMapping("/update-user")
    public String showUpdateUser(@RequestParam int userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "home/update-user";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/";
    }



}
