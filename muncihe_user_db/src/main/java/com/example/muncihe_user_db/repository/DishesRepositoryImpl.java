package com.example.muncihe_user_db.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.muncihe_user_db.model.Dishes;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

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
            dishes.setIsVeg(rs.getBoolean("is_veg"));
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

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Dishes.class), restaurantId);
    }

    @Override
    public void addDish(Dishes dish) {
        String sql = "INSERT INTO dishes (descrip, is_veg, name, price, restaurant_fk, picture) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, dish.getDescrip(), dish.getIsVeg(), dish.getName(), dish.getPrice(),
                dish.getRestaurantId(), dish.getPicture());
    }

    @Override
    public void removeDish(int dishId) {
        String sql = "DELETE FROM dishes WHERE id = ?";
        jdbcTemplate.update(sql, dishId);
    }
}
