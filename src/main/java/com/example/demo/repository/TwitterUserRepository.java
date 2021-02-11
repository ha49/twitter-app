package com.example.demo.repository;

import com.example.demo.entity.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterUserRepository extends JpaRepository<TwitterUser, Long> {
    TwitterUser findUserByUsername(String username);

    TwitterUser findUserByEmail(String email);
}
