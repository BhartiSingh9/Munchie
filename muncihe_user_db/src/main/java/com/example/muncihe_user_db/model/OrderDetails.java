package com.example.muncihe_user_db.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;



@Table("orders")
@Data
public class OrderDetails {
    @Id
    private int id;

   
    @Column("dish_fk")
    private int dishId;
    @Column("order_fk")
    private int orderId;

    
    @Column("quantity")
    private int quantity;
   
    
}
