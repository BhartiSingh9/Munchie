package com.example.muncihe_user_db.orders;

import com.example.muncihe_user_db.dto.OrderDetailsDto;
import com.example.muncihe_user_db.model.OrderDetails;
import com.example.muncihe_user_db.repository.OrderDetailsRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailsRepository orderDetailsRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailsRepository= orderDetailsRepository;
    }

    @Override
    public List<Orders> getAllOrders() {
        List<Orders> orders = orderRepository.getAllOrders();

        if (orders == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to retrieve orders");
        }

        if (orders.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No orders found");
        }

        return orders;
    }
    @Override
    public void placeOrder(OrderDto orderDto) {

        Orders order = new Orders();
        order.setUserId(orderDto.getUserId());
        order.setRestaurantId(orderDto.getRestaurantId());
        order.setOrder_date_time(LocalDateTime.now()); 
        order.setPayment_method(orderDto.getPaymentMethod());
        order.setTotal_cost(orderDto.getTotalCost());

        orderRepository.save(order);

        for (OrderDetailsDto orderDetailsDTO : orderDto.getOrderDetails()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(order.getId()); 
            orderDetails.setDishId(orderDetailsDTO.getDishId());
            orderDetails.setQuantity(orderDetailsDTO.getQuantity());

            orderDetailsRepository.save(orderDetails);
        }
    }
}
