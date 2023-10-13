package com.example.muncihe_user_db.service;

import com.example.muncihe_user_db.model.Restaurant;
import com.example.muncihe_user_db.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }
    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }
    @Override
    public void removeRestaurant(Long restaurantId) {
        restaurantRepository.removeRestaurant(restaurantId);
    }
}
