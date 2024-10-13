package com.abdala.demo.service.dto;

import lombok.Data;

@Data
public class CreateUserDTO {
    private String username;
    private String email;
    private String password;
    private String bio;

}

