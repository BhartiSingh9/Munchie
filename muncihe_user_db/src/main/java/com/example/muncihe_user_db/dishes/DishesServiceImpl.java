package com.example.muncihe_user_db.dishes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class DishesServiceImpl implements DishesService {
    private DishesRepository dishesRepository;

    public DishesServiceImpl(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    @Override
    public List<Dishes> getAllDishes() {
        List<Dishes> dishes = dishesRepository.getAllDishes();
        if (dishes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No dishes found");
        }
        return dishes;
    }

    public List<Dishes> getDishesByRestaurantId(int restaurantId) {
        List<Dishes> dishes = dishesRepository.getDishesByRestaurantId(restaurantId);
        if (dishes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No dishes found");
        }
        return dishes;
    }

    @Override
    public void addDish(Dishes dish) {
        if (dish.getDescrip() == null || dish.getDescrip().isEmpty()
                || dish.getIsVeg() == null
                || dish.getName() == null || dish.getName().isEmpty()
                || dish.getPrice() == null
                || dish.getRestaurantId() <= 0
                || dish.getPicture() == null || dish.getPicture().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request: Invalid dish data");
        }

        dishesRepository.addDish(dish);
    }

    @Override
    public void removeDish(int dishId) {
        if (dishId <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request: Invalid dish ID");
        }

        dishesRepository.removeDish(dishId);
    }
}
