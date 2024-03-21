package com.example.emssome.services;

import com.example.emssome.models.Post;
import com.example.emssome.models.User;
import com.example.emssome.repositories.PostRepository;
import com.example.emssome.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
