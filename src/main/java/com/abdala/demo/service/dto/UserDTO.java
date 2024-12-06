package com.abdala.demo.service.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

  private Long id;
    private   String bio ;
    private LocalDateTime createdAt;
    private   String password ;


    private String Name ;


    private String email ;

}
