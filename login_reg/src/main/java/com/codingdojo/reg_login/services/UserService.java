package com.codingdojo.reg_login.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.reg_login.models.User;
import com.codingdojo.reg_login.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User newUser, BindingResult result) {
        // Perform additional validations and user creation logic
        // For example, you can check if the user already exists in the database
        // and handle any validation errors

        if (result.hasErrors()) {
            // Handle validation errors
            return null;
        }

        // Save the new user to the database
        return userRepository.save(newUser);
    }

    public User login(String email, String password, BindingResult result) {
        // Perform additional validations and user login logic
        // For example, you can check if the provided credentials are valid

        if (result.hasErrors()) {
            // Handle validation errors
            return null;
        }

        // Retrieve the user from the database based on the provided credentials
        Optional<User> userOptional = userRepository.findByEmail(email);
        User user = userOptional.orElse(null);

        if (user == null || !user.getPassword().equals(password)) {
            // Handle invalid credentials
            return null;
        }

        return user;
    }
}



