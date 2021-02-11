package com.example.demo.controller;

import com.example.demo.entity.TwitterUser;
import com.example.demo.entity.UserRelationship;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.UserRelationshipRepository;
import com.example.demo.repository.TwitterUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class UserRelationshipController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRelationshipController.class);

    private TwitterUserRepository twitterUserRepository;
    private UserRelationshipRepository userRelationshipRepository;


    public UserRelationshipController(TwitterUserRepository twitterUserRepository,
                                      UserRelationshipRepository userRelationshipRepository) {
        this.twitterUserRepository = twitterUserRepository;
        this.userRelationshipRepository = userRelationshipRepository;
    }

    @PostMapping("/follow")
    public UserRelationship followSomeone(@RequestBody UserRelationship relationship) {
        TwitterUser follower = twitterUserRepository.findById(relationship.getFollower().getId()).orElseThrow(
                () -> new UserNotFoundException("follower user id not found ")
        );

        TwitterUser followed = twitterUserRepository.findById(relationship.getFollowed().getId()).orElseThrow(
                () -> new UserNotFoundException("following  user id not found ")
        );

        return userRelationshipRepository.save(relationship);

    }


}
