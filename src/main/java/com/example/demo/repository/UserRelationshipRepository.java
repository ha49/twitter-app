package com.example.demo.repository;

import com.example.demo.entity.TwitterUser;
import com.example.demo.entity.UserRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRelationshipRepository
        extends JpaRepository<UserRelationship, Long> {


}
