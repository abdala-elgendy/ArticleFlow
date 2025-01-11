package com.abdala.demo.repository;



import com.abdala.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepo extends JpaRepository<User,Long> {

    // Custom query to get followers of a user
    @Query("SELECT u FROM User u JOIN u.followers f WHERE f.id = :userId")
    List<User> findFollowersByUserId(@Param("userId") Long userId);

    // Custom query to get users that a user is following
    @Query("SELECT u FROM User u JOIN u.following f WHERE f.id = :userId")
    List<User> findFollowingByUserId(@Param("userId") Long userId);
}

