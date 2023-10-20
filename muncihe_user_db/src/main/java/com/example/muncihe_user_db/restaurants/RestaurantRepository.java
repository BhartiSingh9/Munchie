package com.example.muncihe_user_db.restaurants;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getAllRestaurants();
    void addRestaurant(Restaurant restaurant);
    void removeRestaurant(int restaurantId);
    Restaurant findRestaurantById(int restaurantId);
}