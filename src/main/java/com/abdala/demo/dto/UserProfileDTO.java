package com.abdala.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserProfileDTO {
    private UserDTO user;
    private List<ArticleDTO> articles;
    private List<UserDTO> followers;
    private List<UserDTO> following;

    // Getters and setters...
}