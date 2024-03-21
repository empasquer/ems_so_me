package com.example.emssome.services;

import com.example.emssome.models.User;
import com.example.emssome.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public User findUserById(int userId) {
        System.out.println("Searching for user with ID: " + userId);
        try {
            User user = userRepository.findUserById(userId);
            if (user != null) {
                System.out.println("User found: " + user.getUsername());
            } else {
                System.out.println("User not found for ID: " + userId);
            }
            return user;
        } catch (Exception e) {
            System.err.println("Error finding user by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public User findUserByUsername(String username) {
        System.out.println("Searching for user with username: " + username);
        try {
            User user = userRepository.findUserByUsername(username);
            if (user != null) {
                System.out.println("User found: " + user.getUsername());
            } else {
                System.out.println("User not found for username: " + username);
            }
            return user;
        } catch (Exception e) {
            System.err.println("Error finding user by username: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
