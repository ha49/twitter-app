package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/account")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public User addNewUser(@RequestBody User user) {

        return userRepository.save(user);
    }

    @GetMapping("/get/{id}")

    public User getUser(@PathVariable long id) {


        return userRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("user with id " + id + " does not exist ")

        );
    }

    @GetMapping("/get/all")
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }
}
