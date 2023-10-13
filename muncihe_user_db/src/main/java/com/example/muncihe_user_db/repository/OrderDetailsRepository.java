package com.example.muncihe_user_db.repository;
import com.example.muncihe_user_db.model.OrderDetails;

import java.util.List;

public interface OrderDetailsRepository {
    List<OrderDetails> getAllOrderDetails();
    List<OrderDetails> getOrderDetailsByOrderId(int orderId);
}


