package com.abdala.demo.controller;



import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.service.UserService;
import com.abdala.demo.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public List<Article> getUserArticles(@PathVariable Long id) {
        return userService.getUserArticles(id);
    }

    @GetMapping
    public List<ArticleFavorite> getUserArticleFavorites(@PathVariable Long id) {
        return userService.getUserArticleFavorites(id);
    }

    @GetMapping
    public List<UserFollow> getUserFollow(@PathVariable Long id) {
        return userService.getUserFollow(id);
    }
}

