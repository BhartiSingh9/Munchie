package com.example.muncihe_user_db.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.muncihe_user_db.model.Dishes;
import com.example.muncihe_user_db.service.DishesService;


import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishesController {
    private final DishesService dishesService;

    public DishesController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @GetMapping
    public ResponseEntity<List<Dishes>> getAllDishes() {
        List<Dishes> dishes = dishesService.getAllDishes();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }
}
