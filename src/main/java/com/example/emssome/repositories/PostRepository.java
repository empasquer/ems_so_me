package com.example.emssome.repositories;

import com.example.emssome.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Post> getPosts() {
        String query = "SELECT * FROM post;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Post.class);
        return jdbcTemplate.query(query, rowMapper);

    }

    public List<Post> getPostsByUserId(int userId) {
        String query = "SELECT * FROM post WHERE user_id = ?";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return jdbcTemplate.query(query, rowMapper, userId);
    }
}
