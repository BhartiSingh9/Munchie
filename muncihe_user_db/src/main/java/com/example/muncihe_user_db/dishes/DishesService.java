package com.example.muncihe_user_db.dishes;

import java.util.List;

public interface DishesService {
     List<Dishes> getAllDishes();
     List<Dishes> getDishesByRestaurantId(int restaurantId);
     void addDish(Dishes dish);
    void removeDish(int dishId);
}
