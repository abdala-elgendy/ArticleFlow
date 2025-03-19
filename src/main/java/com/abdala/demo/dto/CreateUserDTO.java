package com.abdala.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateUserDTO {
    private String username;
    private String email;
    private String password;
    private String bio;

    private LocalDateTime createdAt;

}
