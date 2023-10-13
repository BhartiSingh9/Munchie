package com.example.muncihe_user_db.service;

import java.util.List;
import com.example.muncihe_user_db.model.OrderDetails;

public interface OrderDetailsService {
    List<OrderDetails> getAllOrderDetails();
    List<OrderDetails> getOrderDetailsByOrderId(int orderId);
}
