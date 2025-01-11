package com.abdala.demo.controller;



import com.abdala.demo.entity.Article;
//import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
//import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.service.UserService;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateUserDTO;
import com.abdala.demo.service.dto.UpdateUserDTO;
import com.abdala.demo.service.dto.UserDTO;
import com.abdala.demo.service.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public  ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        UserDTO userDTO = userService.createUser(createUserDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
       // if(userDTO.getId()!=1)
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
       // return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO>  updateUser(@PathVariable Long  id, @RequestBody UpdateUserDTO updateUserDTO) {

        UserDTO updatedUser = userService.updateUser(id, updateUserDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }



    @GetMapping("/{userId}/articles")
    public ResponseEntity<List<ArticleDTO>> getUserArticles(@PathVariable Long userId) {
        List<ArticleDTO> articles = userService.getUserArticles(userId);
        return new ResponseEntity<>(articles, HttpStatus.OK);
   }
    @GetMapping("/{userId}/followers")
    public ResponseEntity<List<UserDTO>> getFollowers(@PathVariable Long followerId) {
        List<UserDTO> followers = userService.getFollowers(followerId);
        return ResponseEntity.ok(followers);
    }

}

