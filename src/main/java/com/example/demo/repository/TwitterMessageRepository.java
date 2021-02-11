package com.example.demo.repository;

import com.example.demo.entity.TwitterMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterMessageRepository extends JpaRepository<TwitterMessage, Long> {

}
