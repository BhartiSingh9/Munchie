package com.example.muncihe_user_db.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.example.muncihe_user_db.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), email);
        } catch (Exception e) {
            
        }
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT * FROM user";
        List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
        return users;
    }
    @Override
    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
        } catch (Exception e) {

        }
        return Optional.ofNullable(user);
    }
    

}
