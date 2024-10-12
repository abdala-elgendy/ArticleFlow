package com.abdala.demo.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


    private   String bio ;


    private   String password ;


    private String Name ;


    private String email ;
}
