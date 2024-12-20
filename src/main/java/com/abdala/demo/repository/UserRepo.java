package com.abdala.demo.repository;



import com.abdala.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {


//    @Query("select u from User u where u.id = :Id")
//    Optional<User> findById(@Param("id")int id);
//
//   // List<User> findFollowedUsersByUserId(Integer userId);
//   @Query("SELECT U FROM User U where U.email = :email")
//    Optional<User> findByEmail(@Param("email")String email);

   // boolean existsByEmail(String email);
}

