package com.example.muncihe_user_db.restaurants;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    void addRestaurant(Restaurant restaurant);
    void removeRestaurant(int restaurantId);
    Restaurant getRestaurantDetailsById(int restaurantId);

}
