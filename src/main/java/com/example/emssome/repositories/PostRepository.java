package com.example.emssome.repositories;

import com.example.emssome.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Post> getPosts() {
        String query = "SELECT * FROM post ORDER BY created_at DESC";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public List<Post> getPostsByUserId(int userId) {
        String query = "SELECT * FROM post WHERE user_id = ? ORDER BY created_at DESC";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return jdbcTemplate.query(query, rowMapper, userId);
    }

    public void insertNewPost(int userId, String content, LocalDateTime currentDate) {
        String query = "INSERT INTO post (user_id, content, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, userId, content, currentDate);
    }


}
