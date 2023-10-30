package com.example.muncihe_user_db.orders;

import java.util.List;

public interface OrderRepository {
     List<Orders> getAllOrders();

     void save(Orders order);


     List<Orders> getOrdersByUserId(int userId);
}
