package com.example.muncihe_user_db.service;

import com.example.muncihe_user_db.model.Orders;
import com.example.muncihe_user_db.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
