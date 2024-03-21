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
    public User findUserById(int postUserId) {
        return userRepository.findUserById(postUserId);
    }
}
