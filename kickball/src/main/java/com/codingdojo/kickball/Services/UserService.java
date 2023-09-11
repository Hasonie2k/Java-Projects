package com.codingdojo.kickball.Services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.kickball.Models.User;
import com.codingdojo.kickball.Repositories.UserRepo;
import com.codingdojo.kickball.validates.LoginValidator;

@Service
public class UserService {
    @Autowired
    private UserRepo uRepo;

    public User findByid(Long id) {
        return this.uRepo.findById(id).orElse(null);
    }

    public User register(User newUser, BindingResult result) {
        Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());

        if (potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "Email already registered. Choose a different email.");
        }

        if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
        }

        if (result.hasErrors()) {
            return null;
        }

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return this.uRepo.save(newUser);
    }

    public User login(LoginValidator newLoginObject, BindingResult result) {
        Optional<User> potentialUser = uRepo.findByEmail(newLoginObject.getEmail());

        if (potentialUser.isPresent()) {
            User user = potentialUser.get();
            if (!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
                result.rejectValue("password", "Matches", "Invalid Password!");
            }
            return user;
        } else {
            result.rejectValue("email", "Matches", "Email not registered.");
            return null;
        }
    }
}

