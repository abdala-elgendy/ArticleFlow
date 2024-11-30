package com.abdala.demo.service.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserFollowDTO {
    private Integer id;
    private Integer followedUserId;
    private LocalDateTime createdAt;
}

