package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exceptions.EmailAddressAlreadyTakenException;
import com.example.demo.exceptions.UserNameAlreadyTakenException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public User addNewUser(@RequestBody User user) {
        if (userRepository.findUserByUsername(user.getUsername()) != null) {
            throw new UserNameAlreadyTakenException("username " + user.getUsername() + " is already taken!");
        } else if (userRepository.findUserByEmail(user.getEmail()) != null) {
            throw new EmailAddressAlreadyTakenException("Email " + user.getEmail() + " is already taken!");
        } else {
            LOGGER.info("new account " + user.getUsername() + " is being created");
            return userRepository.save(user);
        }
    }

    @GetMapping("/get/{id}")

    public User getUser(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("user with id " + id + " does not exist ")
        );
    }

    @GetMapping("/get/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }
}
