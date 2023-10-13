package com.example.muncihe_user_db.repository;


import com.example.muncihe_user_db.model.Restaurant;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        String sql = "SELECT * from restaurant";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Restaurant.class));
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO restaurant (name, address, city, close_time, cuisine_type, descrip, is_pureveg, license_id, open_time, phone_number, ratings, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(
            sql,
            restaurant.getName(),
            restaurant.getAddress(),
            restaurant.getCity(),
            restaurant.getClose_time(),
            restaurant.getCuisineType(),
            restaurant.getDescrip(),
            restaurant.is_pureveg(),
            restaurant.getLicense_id(),
            restaurant.getOpen_time(),
            restaurant.getPhoneNumber(),
            restaurant.getRatings(),
            restaurant.getPicture()
        );
    }

    @Override
    public void removeRestaurant(Long restaurantId) {
        String sql = "DELETE FROM restaurant WHERE id = ?";
        jdbcTemplate.update(sql, restaurantId);
    }
    
}
