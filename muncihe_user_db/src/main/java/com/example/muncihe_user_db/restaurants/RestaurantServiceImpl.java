package com.example.muncihe_user_db.restaurants;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

  
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.getAllRestaurants();
        if (restaurants.isEmpty()) {
            throw new NoSuchElementException("No restaurants found");
        }
        return restaurants;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant object is null");
        }

        // Custom validation for all fields
        if (restaurant.getName() == null || restaurant.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }
        if (restaurant.getAddress() == null || restaurant.getAddress().isEmpty()) {
            throw new IllegalArgumentException("Address is required.");
        }
        if (restaurant.getCity() == null || restaurant.getCity().isEmpty()) {
            throw new IllegalArgumentException("City is required.");
        }
        if (restaurant.getClose_time() == null) {
            throw new IllegalArgumentException("Close time is required.");
        }
        if (restaurant.getCuisineType() == null || restaurant.getCuisineType().isEmpty()) {
            throw new IllegalArgumentException("Cuisine type is required.");
        }
        if (restaurant.getDescrip() == null || restaurant.getDescrip().isEmpty()) {
            throw new IllegalArgumentException("Description is required.");
        }
        if (restaurant.getLicense_id() == null || restaurant.getLicense_id().isEmpty()) {
            throw new IllegalArgumentException("License ID is required.");
        }
        if (restaurant.getOpen_time() == null) {
            throw new IllegalArgumentException("Open time is required.");
        }
        if (restaurant.getPhoneNumber() == 0) {
            throw new IllegalArgumentException("Phone number is required.");
        }
        if (restaurant.getRatings() < 0 || restaurant.getRatings() > 5) {
            throw new IllegalArgumentException("Ratings must be between 0 and 5.");
        }
        if (restaurant.getPicture() == null || restaurant.getPicture().isEmpty()) {
            throw new IllegalArgumentException("Picture URL is required.");
        }

        restaurantRepository.addRestaurant(restaurant);
    }

    @Override
    public void removeRestaurant(int restaurantId) {
        if (restaurantId <= 0) {
            throw new IllegalArgumentException("Restaurant ID is invalid.");
        }

        try {
            restaurantRepository.findRestaurantById(restaurantId);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Restaurant not found");
        }

        restaurantRepository.removeRestaurant(restaurantId);
    }
}
