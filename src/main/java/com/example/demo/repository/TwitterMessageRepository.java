package com.example.demo.repository;

import com.example.demo.entity.TwitterMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterMessageRepository extends JpaRepository<TwitterMessage, Long> {

    @Query("SELECT m FROM TwitterMessage m inner join UserRelationship ur on ur.followed.id = m.twitterUser.id " +

            " WHERE  ur.follower.id = :userId order by m.messageTime desc")
    Iterable<TwitterMessage> getMyTimeline(@Param("userId") Long userId);


    @Query("SELECT m FROM TwitterMessage m WHERE m.twitterUser.id=:userId " +

            " order by m.messageTime desc")
    Iterable<TwitterMessage> getMyTweets(@Param("userId") Long userId);


    @Query("SELECT m FROM TwitterMessage m WHERE m.twitterUser.username=:myUsername " +

            " order by m.messageTime desc")
    Iterable<TwitterMessage> getMyTweetsByUsername(String myUsername);
}
