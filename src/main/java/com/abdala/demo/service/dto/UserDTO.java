package com.abdala.demo.service.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

  private Long id;
    private   String bio ;
    private LocalDateTime createdAt;



    private String Name ;

 public UserDTO(){
   super();
 };
    private String email ;
  private static Set<Long> followerIds;
  private static Set<Long> followingIds;


  public static void setFollowerIds(Set<Long> followerIds) {
   UserDTO.followerIds = followerIds;
  }

  public static void setFollowingIds(Set<Long> followingIds) {
    UserDTO.followingIds = followingIds;
  }
}
