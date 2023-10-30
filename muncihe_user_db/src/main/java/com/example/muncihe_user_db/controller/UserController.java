package com.example.muncihe_user_db.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.muncihe_user_db.model.User;
import com.example.muncihe_user_db.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

   
    @PostMapping("/getbyemail")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        // Retrieve user data by email using the UserService
        Optional<User> dbUser = userService.getUserByEmail(user.getEmail());

        if (dbUser.isPresent() && dbUser.get().getPassword().equals(user.getPassword())) {
            // Authentication successful
            String token = generateToken(); // Implement token generation logic
            return ResponseEntity.ok(token);
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
@GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(users);
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable int id) {
    Optional<User> user = userService.getUserById(id);

    if (user.isPresent()) {
        return ResponseEntity.ok(user.get());
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}

     private String generateToken() {
        // Implement token generation logic (e.g., using JWT)
        // Return the generated token
        return "your-generated-token";
    }

}
