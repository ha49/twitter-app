package com.example.demo.controller;

import com.example.demo.entity.TwitterUser;
import com.example.demo.exceptions.EmailAddressAlreadyTakenException;
import com.example.demo.exceptions.UserNameAlreadyTakenException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.TwitterUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class TwitterUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterUserController.class);
    private TwitterUserRepository twitterUserRepository;

    public TwitterUserController(TwitterUserRepository twitterUserRepository) {
        this.twitterUserRepository = twitterUserRepository;
    }

    @PostMapping("/signup")
    public TwitterUser addNewUser(@RequestBody TwitterUser twitterUser) {
        if (twitterUserRepository.findUserByUsername(twitterUser.getUsername()) != null) {
            throw new UserNameAlreadyTakenException("username " + twitterUser.getUsername() + " is already taken!");
        } else if (twitterUserRepository.findUserByEmail(twitterUser.getEmail()) != null) {
            throw new EmailAddressAlreadyTakenException("Email " + twitterUser.getEmail() + " is already taken!");
        } else {
            LOGGER.info("new account " + twitterUser.getUsername() + " is being created");
            return twitterUserRepository.save(twitterUser);
        }
    }

    @GetMapping("/get/{id}")

    public TwitterUser getUser(@PathVariable long id) {
        return twitterUserRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("user with id " + id + " does not exist ")
        );
    }

    @GetMapping("/get/all")
    public List<TwitterUser> getAllUsers() {
        return twitterUserRepository.findAll();

    }
}
