package com.example.muncihe_user_db.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.muncihe_user_db.model.Dishes;


@Repository
public class DishesRepositoryImpl implements DishesRepository{
    private final JdbcTemplate jdbcTemplate;
    
    public DishesRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<Dishes> getAllDishes() {
    String sql = "SELECT * from dishes";

    return jdbcTemplate.query(
        sql,
        (rs, rowNum) -> {
            return new Dishes(
                rs.getInt("id"),
                rs.getString("descrip"),
                rs.getBoolean("is_veg"),
                rs.getString("name"),
                rs.getString("picture"),
                rs.getDouble("price"),
                rs.getLong("restaurant_fk")
            );
        }
    );
}

    
}
