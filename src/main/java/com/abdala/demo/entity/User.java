package com.abdala.demo.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name="User")
public class User {

    // define fields

    @Id
    @Column(name="id")
    @GeneratedValue(generator = "Long")
    @GenericGenerator(
            name = "Long",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    private Long id;

    @Column(name="bio")
    private String bio;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="name")
    private String Name;

    @Column(name="email")
    private String email;


    // define constructors

    public User() {

    }

    public User( String Name, String email) {
        this.id = id;
        this.Name = Name;

        this.email = email;
    }



    // define getter/setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String firstName) {
        this.Name = Name;
    }

    public String getBio(){
        return bio;

    }

    public void setBio(String bio){
        this.bio=bio;

    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password=password;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // define tostring

    @Override
    public String toString() {
        return "User: [id=" + id +" , bio= "+bio + ", Name=" + Name +  ", email=" + email + "]";
    }

}











