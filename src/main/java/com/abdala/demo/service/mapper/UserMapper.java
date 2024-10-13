package com.abdala.demo.service.mapper;

import com.abdala.demo.entity.User;
import com.abdala.demo.service.dto.CreateUserDTO;
import com.abdala.demo.service.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setBio(user.getBio());
       // dto.setImageUrl(user.getImageUrl());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public User toEntity(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        user.setBio(createUserDTO.getBio());
        user.setImageUrl(createUserDTO.getImageUrl());
        return user;
    }
}

