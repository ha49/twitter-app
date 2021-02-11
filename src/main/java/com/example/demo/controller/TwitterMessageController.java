package com.example.demo.controller;

import com.example.demo.entity.TwitterMessage;
import com.example.demo.entity.TwitterUser;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.TwitterMessageRepository;
import com.example.demo.repository.TwitterUserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/account")
public class TwitterMessageController {

    private TwitterMessageRepository twitterMessageRepository;
    private TwitterUserRepository twitterUserRepository;

    public TwitterMessageController(TwitterMessageRepository twitterMessageRepository, TwitterUserRepository twitterUserRepository) {
        this.twitterMessageRepository = twitterMessageRepository;
        this.twitterUserRepository = twitterUserRepository;
    }


    @PostMapping("/tweet")
    public TwitterMessage newTweet(@RequestBody TwitterMessage twitterMessage) {

        TwitterUser twitterUser =
                twitterUserRepository.findById(twitterMessage.getTwitterUser().getId()).orElseThrow(
                        () -> new UserNotFoundException("user id not found ")
                );

        LocalDateTime messageTime = LocalDateTime.now();
        twitterMessage.setMessageTime(messageTime);
        return twitterMessageRepository.save(twitterMessage);

    }


}
