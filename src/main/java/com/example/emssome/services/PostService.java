package com.example.emssome.services;

import com.example.emssome.models.Post;
import com.example.emssome.models.User;
import com.example.emssome.repositories.PostRepository;
import com.example.emssome.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public List<Post> getPostsByUserId(int userId) {
        return postRepository.getPostsByUserId(userId);
    }


    public void insertNewPost(int userId, String content, LocalDateTime currentDate) {
        postRepository.insertNewPost(userId, content, currentDate);
    }
}
