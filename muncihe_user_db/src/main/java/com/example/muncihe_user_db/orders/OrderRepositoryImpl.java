package com.example.muncihe_user_db.orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
                order.setUserId(rs.getInt("UserID"));
                order.setRestaurantId(rs.getInt("RestaurantID"));
                order.setOrder_date_time(rs.getTimestamp("Order_date_time").toLocalDateTime());
                order.setPayment_method(rs.getString("Payment_Method"));
                order.setTotal_cost(rs.getBigDecimal("Total_Cost").doubleValue());

                return order;
            }
        });
    }

    @Override
    public void save(Orders order) {
        String sql = "INSERT INTO orders (UserID, RestaurantID, Order_date_time, Payment_Method, Total_Cost) " +
                "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, order.getUserId(), order.getRestaurantId(),
                order.getOrder_date_time(), order.getPayment_method(),
                order.getTotal_cost());
    }

    @Override
    public List<Orders> getOrdersByUserId(int userId) {
        String sql = "SELECT * FROM orders WHERE UserID = ?";

        return jdbcTemplate.query(
                sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setInt(1, userId);
                    }
                },
                new RowMapper<Orders>() {
                    @Override
                    public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Orders order = new Orders();
                        order.setId(rs.getInt("ID"));
                        order.setUserId(rs.getInt("UserID"));
                        order.setRestaurantId(rs.getInt("RestaurantID"));
                        order.setOrder_date_time(rs.getTimestamp("Order_date_time").toLocalDateTime());
                        order.setPayment_method(rs.getString("Payment_Method"));
                        order.setTotal_cost(rs.getBigDecimal("Total_Cost").doubleValue());

                        return order;
                    }
                });
    }

}
