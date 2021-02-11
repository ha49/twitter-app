package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_relationship")
public class UserRelationship {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToOne
    private TwitterUser follower;

    @ManyToOne
    private TwitterUser followed;

    public UserRelationship() {
    }

    public UserRelationship(TwitterUser follower, TwitterUser followed) {
        this.follower = follower;
        this.followed = followed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TwitterUser getFollower() {
        return follower;
    }

    public void setFollower(TwitterUser follower) {
        this.follower = follower;
    }

    public TwitterUser getFollowed() {
        return followed;
    }

    public void setFollowed(TwitterUser followed) {
        this.followed = followed;
    }
}
