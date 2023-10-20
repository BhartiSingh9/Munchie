package com.example.muncihe_user_db.orders;

import java.time.LocalDateTime;
import java.util.List;

import com.example.muncihe_user_db.dto.OrderDetailsDto;

public class OrderDto {
    private int id;
    private int userId;
    private int restaurantId;
    private LocalDateTime orderDateTime;
    private String paymentMethod;
    private double totalCost;
    private List<OrderDetailsDto> orderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<OrderDetailsDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDto> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
