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

@RestController
@RequestMapping("/api/users")
public class UserController {

//    @Autowired
//    private UserRepo userRepository;
//
//    @Autowired
//    private ArticleRepo articleRepository;
//
//    @Autowired
//    private ArticleMapper articleMapper;

    @Autowired
    private UserService userService;

    @PostMapping
    public  ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        UserDTO userDTO = userService.createUser(createUserDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO>  updateUser(@PathVariable int  id, @RequestBody UpdateUserDTO updateUserDTO) {

        UserDTO updatedUser = userService.updateUser(id, updateUserDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }



//    @GetMapping("/{userId}/articles")
//    public ResponseEntity<List<ArticleDTO>> getUserArticles(@PathVariable Integer userId) {
//        List<ArticleDTO> articles = userService.getUserArticles(userId);
//        return new ResponseEntity<>(articles, HttpStatus.OK);
//    }

//
//    @DeleteMapping("/{userId}/unfollow/{unfollowUserId}")
//    public ResponseEntity<Void> unfollowUser(@PathVariable Integer userId, @PathVariable Integer unfollowUserId) {
//        userService.unfollowUser(userId, unfollowUserId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @GetMapping("/{userId}/following")
//    public ResponseEntity<List<UserDTO>> getUserFollow(@PathVariable Integer userId) {
//        List<UserDTO> following = userService.getUserFollow(userId);
//        return new ResponseEntity<>(following, HttpStatus.OK);
//    }
}

