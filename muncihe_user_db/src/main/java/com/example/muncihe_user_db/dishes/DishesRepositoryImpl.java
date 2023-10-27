package com.example.muncihe_user_db.dishes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.EmptyResultDataAccessException;


@Repository
public class DishesRepositoryImpl implements DishesRepository {
    private final JdbcTemplate jdbcTemplate;

    public DishesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
public List<Dishes> getAllDishes() {
    String sql = "SELECT * from dishes";

    return jdbcTemplate.query(sql, new RowMapper<Dishes>() {
        @Override
        public Dishes mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dishes dishes = new Dishes();
            dishes.setId(rs.getInt("id"));
            dishes.setDescrip(rs.getString("descrip"));
            dishes.setIs_veg(rs.getBoolean("is_veg"));
            dishes.setPicture(rs.getString("picture"));
            dishes.setName(rs.getString("name"));
            dishes.setPrice(rs.getDouble("price"));
            dishes.setRestaurantId(rs.getInt("restaurant_fk"));

            return dishes;
        }
    });
}

@Override
public List<Dishes> getDishesByRestaurantId(int restaurantId) {
    String sql = "SELECT * from dishes WHERE restaurant_fk = ?";

    return jdbcTemplate.query(sql, new RowMapper<Dishes>() {
        @Override
        public Dishes mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dishes dishes = new Dishes();
            dishes.setId(rs.getInt("id"));
            dishes.setDescrip(rs.getString("descrip"));
            dishes.setIs_veg(rs.getBoolean("is_veg"));
            dishes.setPicture(rs.getString("picture"));
            dishes.setName(rs.getString("name"));
            dishes.setPrice(rs.getDouble("price"));
            dishes.setRestaurantId(rs.getInt("restaurant_fk"));

            return dishes;
        }
    }, restaurantId);
}


    @Override
    public void addDish(Dishes dish) {
        // Custom validation for all fields
        if (dish.getDescrip() == null || dish.getDescrip().isEmpty()) {
            throw new IllegalArgumentException("Description is required.");
        }
        if (dish.getIs_veg() == null) {
            throw new IllegalArgumentException("isVeg is required.");
        }
        if (dish.getName() == null || dish.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (dish.getPrice() == null) {
            throw new IllegalArgumentException("Price is required.");
        }
        if (dish.getRestaurantId() <= 0) {
            throw new IllegalArgumentException("Invalid restaurant ID.");
        }
        if (dish.getPicture() == null || dish.getPicture().isEmpty()) {
            throw new IllegalArgumentException("Picture URL is required.");
        }

        String sql = "INSERT INTO dishes (descrip, is_veg, name, price, restaurant_fk, picture) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            jdbcTemplate.update(
                sql,
                dish.getDescrip(),
                dish.getIs_veg(),
                dish.getName(),
                dish.getPrice(),
                dish.getRestaurantId(),
                dish.getPicture()
            );
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("The restaurant with ID " + dish.getRestaurantId() + " was not found.");
        }
    }

    @Override
    public void removeDish(int dishId) {
        // Custom validation
        if (dishId <= 0) {
            throw new IllegalArgumentException("Invalid dish ID.");
        }

        String sql = "DELETE FROM dishes WHERE id = ?";
        jdbcTemplate.update(sql, dishId);
    }
}
