package com.example.muncihe_user_db.service;

import com.example.muncihe_user_db.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
    Optional<User> getUserById(int id);
}
