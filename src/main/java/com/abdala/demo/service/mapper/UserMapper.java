package com.abdala.demo.service.mapper;

import com.abdala.demo.entity.User;
import com.abdala.demo.service.dto.CreateUserDTO;
import com.abdala.demo.service.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public static UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setBio(user.getBio());

        dto.setCreatedAt(user.getCreatedAt());
        Set<Long> followerIds = user.getFollowers().stream()
                .map(User::getId)
                .collect(Collectors.toSet());
        UserDTO.setFollowerIds(followerIds);

        Set<Long> followingIds = user.getFollowing().stream()
                .map(User::getId)
                .collect(Collectors.toSet());
        UserDTO.setFollowingIds(followingIds);
        return dto;
    }

    public User toEntity(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.getUsername());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        user.setBio(createUserDTO.getBio());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }



}

