package com.example.muncihe_user_db.restaurants;

import org.springframework.dao.EmptyResultDataAccessException;
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
        // Custom validation for all fields
        if (restaurant.getName() == null || restaurant.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (restaurant.getAddress() == null || restaurant.getAddress().isEmpty()) {
            throw new IllegalArgumentException("Address is required.");
        }
        if (restaurant.getCity() == null || restaurant.getCity().isEmpty()) {
            throw new IllegalArgumentException("City is required.");
        }
        if (restaurant.getClose_time() == null) {
            throw new IllegalArgumentException("Close time is required.");
        }
        if (restaurant.getCuisineType() == null || restaurant.getCuisineType().isEmpty()) {
            throw new IllegalArgumentException("Cuisine type is required.");
        }
        if (restaurant.getDescrip() == null || restaurant.getDescrip().isEmpty()) {
            throw new IllegalArgumentException("Description is required.");
        }
        if (restaurant.getLicense_id() == null || restaurant.getLicense_id().isEmpty()) {
            throw new IllegalArgumentException("License ID is required.");
        }
        if (restaurant.getOpen_time() == null) {
            throw new IllegalArgumentException("Open time is required.");
        }
        if (restaurant.getPhoneNumber() == 0) {
            throw new IllegalArgumentException("Phone number is required.");
        }
        if (restaurant.getRatings() < 0 || restaurant.getRatings() > 5) {
            throw new IllegalArgumentException("Ratings must be between 0 and 5.");
        }
        if (restaurant.getPicture() == null || restaurant.getPicture().isEmpty()) {
            throw new IllegalArgumentException("Picture URL is required.");
        }
      
    
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
    public void removeRestaurant(int restaurantId) {
        // Custom validation
        if (restaurantId <= 0) {
            throw new IllegalArgumentException("Invalid restaurant ID.");
        }

        String sql = "DELETE FROM restaurant WHERE id = ?";
        jdbcTemplate.update(sql, restaurantId);
    }

    @Override
    public Restaurant findRestaurantById(int restaurantId) {
        // Custom validation
        if (restaurantId <= 0) {
            throw new IllegalArgumentException("Invalid restaurant ID.");
        }

        String sql = "SELECT * FROM restaurant WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Restaurant.class), restaurantId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
