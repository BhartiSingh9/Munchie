package com.example.muncihe_user_db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.muncihe_user_db.model.Dishes;
import com.example.muncihe_user_db.repository.DishesRepository;

@Service
public class DishesServiceImpl implements DishesService {
    private DishesRepository dishesRepository;

    public DishesServiceImpl(DishesRepository dishesRepository){
        this.dishesRepository=dishesRepository;
    }

    @Override
    public List<Dishes> getAllDishes() {
        return dishesRepository.getAllDishes();
    }
    
}
 