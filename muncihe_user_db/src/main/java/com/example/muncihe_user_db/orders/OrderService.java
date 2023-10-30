package com.example.muncihe_user_db.orders;



import java.util.List;

public interface OrderService {
    List<Orders> getAllOrders();
    void placeOrder(OrderDto orderDto);
    List<Orders> getOrdersByUserId(int userId);

}
