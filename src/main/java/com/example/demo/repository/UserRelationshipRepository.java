package com.example.demo.repository;

import com.example.demo.entity.TwitterUser;
import com.example.demo.entity.UserRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRelationshipRepository
        extends JpaRepository<UserRelationship, Long> {
    @Query("SELECT u FROM TwitterUser u inner join UserRelationship ur on ur.follower.id = u.id " +

            " WHERE  ur.followed.id = :userId")
    Iterable<TwitterUser> findFollowers(
            @Param("userId") Long userId);

    @Query("SELECT u FROM TwitterUser u inner join UserRelationship ur on ur.followed.id = u.id " +

            " WHERE  ur.follower.id = :userId ")
    Iterable<TwitterUser> findFollowing(
            @Param("userId") Long userId);


}
