package com.abdala.demo.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
@Data
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
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User() {

    }

    public User( String Name, String email) {
      //  this.id = id;
        this.Name = Name;

        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String firstName) {
        this.Name = Name;
    }

    public String getBio(){
        return bio;

    }

    public void setBio(String bio){
        this.bio=bio;

    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password=password;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<Article> getArticles() {
        return articles;
    }



    public void removeArticle(Article article) {
        articles.remove(article);
        article.setAuthor(null);
    }
//
//    public void followUser(User user) {
//        this.following.add(user);
//        user.getFollowers().add(this);
//    }
//
//    public void unfollowUser(User user) {
//        this.following.remove(user);
//        user.getFollowers().remove(this);
//    }

    @Override
    public String toString() {
        return "User: [id=" + id +" , bio= "+bio + ", Name=" + Name +  ", email=" + email + "]";
    }

}











