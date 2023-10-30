package com.example.muncihe_user_db.service;

import com.example.muncihe_user_db.model.User;
import com.example.muncihe_user_db.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }
    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
}
