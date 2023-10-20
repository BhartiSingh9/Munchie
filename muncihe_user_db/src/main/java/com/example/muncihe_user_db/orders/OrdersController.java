package com.example.muncihe_user_db.orders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderService orderService;
    private final Logger logger = LoggerFactory.getLogger(OrdersController.class);

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrders() {
        try {
            List<Orders> orders = orderService.getAllOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.error("Bad request in getAllOrders: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Internal server error in getAllOrders: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto, Errors errors) {
        if (errors.hasErrors()) {
            logger.error("Validation errors in placeOrder: " + errors.getAllErrors());
            return new ResponseEntity<>("Validation failed", HttpStatus.BAD_REQUEST);
        }

        try {
            orderService.placeOrder(orderDto);
            logger.info("Order placed successfully.");
            return new ResponseEntity<>("Order placed successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to place the order: " + e.getMessage(), e);
            return new ResponseEntity<>("Failed to place the order", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
