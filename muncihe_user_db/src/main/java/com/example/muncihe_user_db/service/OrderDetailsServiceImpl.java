package com.example.muncihe_user_db.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

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
        List<OrderDetails> orderDetails = orderDetailsRepository.getAllOrderDetails();

        if (orderDetails == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve order details");
        } else if (orderDetails.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No order details found");
        }

        return orderDetails;
    }

    @Override
    public List<OrderDetails> getOrderDetailsByOrderId(int orderId) {
        List<OrderDetails> orderDetails = orderDetailsRepository.getOrderDetailsByOrderId(orderId);

        if (orderDetails == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve order details by order ID");
        } else if (orderDetails.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No order details found for the specified order ID");
        }

        return orderDetails;
    }
}
