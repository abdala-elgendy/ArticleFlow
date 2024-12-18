package com.abdala.demo.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class UserFollow {

   @Id
   @Column(name="id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer  id;

   @ManyToOne
   @JoinColumn(name = "follower_id")
   private User follower;

   @ManyToOne
   @JoinColumn(name = "followee_id")
   private User followee;

   @Column(name="created_at")
   private LocalDateTime createdAt;

   public UserFollow() {
       this.createdAt = LocalDateTime.now();
   }


   public Integer getId() {
       return id;
   }

   public void setId(Integer id) {
       this.id = id;
   }

   public User getFollower() {
       return follower;
   }

   public void setFollower(User follower) {
       this.follower = follower;
   }

   public User getFollowee() {
       return followee;
   }

   public void setFollowee(User followee) {
       this.followee = followee;
   }

   public LocalDateTime getCreatedAt() {
       return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
       this.createdAt = createdAt;
   }
}
