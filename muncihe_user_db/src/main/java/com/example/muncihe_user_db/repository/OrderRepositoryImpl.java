package com.example.muncihe_user_db.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.muncihe_user_db.model.Orders;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
 private final JdbcTemplate jdbcTemplate;

    public OrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
public List<Orders> getAllOrders() {
    String sql = "SELECT * FROM orders";

    return jdbcTemplate.query(sql, new RowMapper<Orders>() {
        @Override
        public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
            Orders order = new Orders();
            order.setId(rs.getInt("ID"));
            order.setUserId(rs.getInt("UserID")); // Use the correct column name
            order.setRestaurantId(rs.getInt("RestaurantID"));
            order.setOrder_date_time(rs.getTimestamp("Order_date_time").toLocalDateTime());
            order.setPayment_method(rs.getString("Payment_Method"));
            order.setTotal_cost(rs.getBigDecimal("Total_Cost").doubleValue());

            return order;
        }
    });
}   
}
