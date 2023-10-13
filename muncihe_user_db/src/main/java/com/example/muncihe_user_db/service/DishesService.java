package com.example.muncihe_user_db.service;

import java.util.List;

import com.example.muncihe_user_db.model.Dishes;

public interface DishesService {
     List<Dishes> getAllDishes();
     List<Dishes> getDishesByRestaurantId(int restaurantId);
     void addDish(Dishes dish);
    void removeDish(int dishId);
}
