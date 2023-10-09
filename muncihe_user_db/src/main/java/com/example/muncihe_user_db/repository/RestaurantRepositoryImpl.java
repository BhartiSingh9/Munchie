package com.example.muncihe_user_db.repository;

import com.example.muncihe_user_db.model.Restaurant;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {
    private final JdbcTemplate jdbcTemplate;

    
    public RestaurantRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        String sql = "SELECT * FROM restaurant";
        return jdbcTemplate.query(
            sql,
            (rs, rowNum) -> new Restaurant(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("city"),
                rs.getString("descrip"),
                rs.getString("address"),
                rs.getString("license_id"),
                rs.getInt("open_time"),
                rs.getInt("close_time"),
                rs.getString("cuisine_type"),
                rs.getLong("phone_number"),
                rs.getDouble("ratings"),
                rs.getBoolean("is_pureveg"),
                rs.getString("picture")
            )
        );
    }
}
