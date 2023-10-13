package com.example.muncihe_user_db.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.muncihe_user_db.model.OrderDetails;
import com.example.muncihe_user_db.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepository.getAllOrderDetails();
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOrderId(int orderId) {
        return orderDetailsRepository.getOrderDetailsByOrderId(orderId);
    }
}
