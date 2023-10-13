package com.example.muncihe_user_db.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;



@Table("orders")
@Data
public class Orders {
    @Id
    private int id;

    @Column("order_date_time")
    private LocalDateTime order_date_time;

    @Column("payment_method")
    private String payment_method;

    @Column("total_cost")
    private double total_cost;
    
    @Column("user_fk")
    private int userId;
    @Column("restaurant_fk")
    private int restaurantId;
    
}
