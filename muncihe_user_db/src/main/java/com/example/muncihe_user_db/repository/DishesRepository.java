package com.example.muncihe_user_db.repository;

import java.util.List;

import com.example.muncihe_user_db.model.Dishes;

public interface DishesRepository {
    List<Dishes> getAllDishes();
    List<Dishes> getDishesByRestaurantId(int restaurantId);
    void addDish(Dishes dish);
    void removeDish(int dishId);

    
}
