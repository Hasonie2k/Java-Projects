package com.codingdojo.kickball.Repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.kickball.Models.User;

public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();
    Optional<User> findByEmail(String Email);
}