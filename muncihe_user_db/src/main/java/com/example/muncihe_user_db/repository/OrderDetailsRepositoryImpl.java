package com.example.muncihe_user_db.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.muncihe_user_db.model.OrderDetails;

@Repository
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderDetailsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        String sql = "SELECT * FROM orderdetails";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OrderDetails.class));
    }
    @Override
    public List<OrderDetails> getOrderDetailsByOrderId(int orderId) {
        String sql = "SELECT * FROM orderdetails WHERE orderId = ?";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OrderDetails.class), orderId);
    }
    @Override
public void save(OrderDetails orderDetails) {
    String sql = "INSERT INTO orderdetails (orderId, dishId, quantity) " +
                 "VALUES (?, ?, ?)";

    jdbcTemplate.update(sql, 
        orderDetails.getOrderId(),
        orderDetails.getDishId(),
        orderDetails.getQuantity()
    );

}

}
