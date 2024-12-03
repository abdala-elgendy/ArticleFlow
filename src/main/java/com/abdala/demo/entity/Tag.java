//package com.abdala.demo.entity;
//
//
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//
//@Entity
//@Data
//@Table(name="tag")
//public class Tag {
//
//    @Id
//    @Column(name="name")
//    private String name;  // Primary key
//
//    @Column(name="created_at")
//    private LocalDateTime createdAt;
//
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//}
