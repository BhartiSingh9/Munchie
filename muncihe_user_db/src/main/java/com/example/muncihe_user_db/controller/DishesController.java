package com.example.muncihe_user_db.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.muncihe_user_db.model.Dishes;
import com.example.muncihe_user_db.service.DishesService;

import org.springframework.http.HttpStatus;

import java.util.List;

@RestController

@RequestMapping("/dishes")
@CrossOrigin("*")
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

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<List<Dishes>> getDishesForRestaurant(@PathVariable int restaurantId) {
        List<Dishes> dishes = dishesService.getDishesByRestaurantId(restaurantId);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @PostMapping("/restaurants/{restaurantId}/add-dish")
    public ResponseEntity<Dishes> addDish(@PathVariable int restaurantId, @RequestBody Dishes dish) {
        dish.setRestaurantId(restaurantId);

        dishesService.addDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.CREATED);
    }

    @DeleteMapping("/restaurants/{restaurantId}/remove/{dishId}")
    public ResponseEntity<Void> removeDish(@PathVariable int restaurantId, @PathVariable int dishId) {
        dishesService.removeDish(dishId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
