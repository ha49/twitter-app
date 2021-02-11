package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TwitterMessage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private TwitterUser twitterUser;

    private String tweet;

    private LocalDateTime messageTime;

    public TwitterMessage(TwitterUser twitterUser, String tweet, LocalDateTime messageTime) {
        this.twitterUser = twitterUser;
        this.tweet = tweet;
        this.messageTime = messageTime;
    }

    public TwitterMessage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TwitterUser getTwitterUser() {
        return twitterUser;
    }

    public void setTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String twit) {
        this.tweet = twit;
    }

    public LocalDateTime getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(LocalDateTime messageTime) {
        this.messageTime = messageTime;
    }
}
