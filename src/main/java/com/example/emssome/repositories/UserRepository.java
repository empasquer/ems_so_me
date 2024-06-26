package com.example.emssome.repositories;

import com.example.emssome.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<User> getUsers() {
        String query = "SELECT * FROM user;";
        RowMapper rowMapper = new BeanPropertyRowMapper(User.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public User findUserById(int userId) {
        String query = "SELECT * FROM user WHERE user_id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        // Ensure to handle the case where no user is found with the given ID
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, userId);
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null if no user is found
        }
    }


    public User findUserByUsername(String username) {
        String query = "SELECT * FROM user WHERE username = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, username);
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null if no user is found
        }
    }

    public void save(User user) {
        if (user.getUserId() == 0) {
            // If the user ID is 0, it means it's a new user, so perform an insert operation
            String query = "INSERT INTO user (username, firstname, lastname, email, bio) " +
                    "VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(query, user.getUsername(), user.getFirstname(), user.getLastname(),
                    user.getEmail(), user.getBio());
        } else {
            // If the user ID is not 0, it means it's an existing user, so perform an update operation
            String query = "UPDATE user SET firstname = ?, lastname = ?, " +
                    "email = ?, bio = ? WHERE user_id = ?";
            jdbcTemplate.update(query, user.getFirstname(), user.getLastname(),
                    user.getEmail(), user.getBio(), user.getUserId());
        }
    }

}
