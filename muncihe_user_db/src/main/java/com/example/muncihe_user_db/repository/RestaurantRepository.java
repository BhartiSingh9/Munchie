package com.example.muncihe_user_db.repository;

import com.example.muncihe_user_db.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> getAllRestaurants();
    void addRestaurant(Restaurant restaurant);
    void removeRestaurant(Long restaurantId);
}
