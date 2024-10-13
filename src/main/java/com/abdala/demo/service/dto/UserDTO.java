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

  private Long id;
    private   String bio ;

    public String getBio() {
        return bio;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    private   String password ;


    private String Name ;


    private String email ;


    public void setId(Long id){
        this.id=id;
    }
}
