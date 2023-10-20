package com.example.muncihe_user_db.dishes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        try {
            List<Dishes> dishes = dishesService.getAllDishes();
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<List<Dishes>> getDishesForRestaurant(@PathVariable int restaurantId) {
        try {
            List<Dishes> dishes = dishesService.getDishesByRestaurantId(restaurantId);
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/restaurants/{restaurantId}/add-dish")
    public ResponseEntity<Dishes> addDish(@PathVariable int restaurantId, @RequestBody Dishes dish) {
        try {
            dish.setRestaurantId(restaurantId);
            dishesService.addDish(dish);
            return new ResponseEntity<>(dish, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/restaurants/{restaurantId}/remove/{dishId}")
    public ResponseEntity<Void> removeDish(@PathVariable int restaurantId, @PathVariable int dishId) {
        try {
            dishesService.removeDish(dishId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
