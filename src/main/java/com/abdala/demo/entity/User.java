package com.abdala.demo.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
@Data
@Getter
@Setter
public class User {



    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)


    private Long id;

    @Column(name="bio")
    private String bio;

    @Column(name="password",nullable = false)
    @JsonIgnore
    private String password;

    @Column(name="name")
    private String Name;

    @Column(name="email")
    private String email;

    @Column(name="created_at")
    private LocalDateTime createdAt;



    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Article> articles = new HashSet<>();




    @ManyToMany
    @JoinTable(
            name = "user_followings",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "followee_id")
    )
    @JsonIgnore
    private Set<User> following = new HashSet<>();

    @ManyToMany(mappedBy = "following")
    @JsonIgnore
    private Set<User> followers = new HashSet<>();

    public User(String name, String email) {
        this.Name=name;
        this.email=email;

    }

    public User() {

    }

    // Other methods (getters, setters, etc.)

    public void followUser(User userToFollow) {
        this.following.add(userToFollow);
        userToFollow.getFollowers().add(this);
    }

    public void unfollowUser(User userToUnfollow) {
        this.following.remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(this);
    }
    @Override
    public String toString() {
        return "User: [id=" + id +" , bio= "+bio + ", Name=" + Name +  ", email=" + email + "]";
    }

}











