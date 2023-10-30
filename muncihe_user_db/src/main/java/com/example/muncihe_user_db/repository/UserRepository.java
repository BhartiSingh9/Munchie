package com.example.muncihe_user_db.repository;

import java.util.List;
import java.util.Optional;

import com.example.muncihe_user_db.model.User;



public interface UserRepository {


    Optional<User> findByEmail(String email);
     List<User> findAllUsers();
     Optional<User> findById(int id);
}
