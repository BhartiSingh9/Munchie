package com.example.muncihe_user_db.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.muncihe_user_db.model.OrderDetails;
import com.example.muncihe_user_db.service.OrderDetailsService;
@RestController
@RequestMapping("/order-details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAllOrderDetails() {
        try {
            List<OrderDetails> orderDetails = orderDetailsService.getAllOrderDetails();
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by-order-id/{orderId}")
    public ResponseEntity<List<OrderDetails>> getOrderDetailsByOrderId(@PathVariable int orderId) {
        try {
            List<OrderDetails> orderDetails = orderDetailsService.getOrderDetailsByOrderId(orderId);
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
