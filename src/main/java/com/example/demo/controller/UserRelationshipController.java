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

    // GET ALL
    @GetMapping("/getrelationships")
    public Iterable<UserRelationship> getAllRelationships() {
        LOGGER.info("/getrelationships☺");
        return userRelationshipRepository.findAll();
    }

    // GET FOLLOWERS
    @GetMapping("/getfollowers/{id}")
    public Iterable<TwitterUser> getFollowers(@PathVariable long id) {
        LOGGER.info("/getfollowers/{id}");

        TwitterUser me = twitterUserRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("following  user id not found "));


        Iterable<TwitterUser> followers = userRelationshipRepository.findFollowers(id);
        return followers;
    }

    // GET FOLLOWING
    @GetMapping("/getfollowing/{id}")
    public Iterable<TwitterUser> getFollowing(@PathVariable long id) {
        LOGGER.info("/getfollowing/{id}");

        TwitterUser me = twitterUserRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("follower user id not found "));


        Iterable<TwitterUser> following = userRelationshipRepository.findFollowing(id);
        return following;
    }

}
