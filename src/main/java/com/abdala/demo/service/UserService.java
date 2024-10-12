package com.abdala.demo.service;



import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.service.dto.UserDTO;
import com.abdala.demo.service.dto.UserDTO;


import java.util.List;

public interface UserService {


    User createUser(User teacherRequest);

    void deleteUser(Long userId);

    User updateUser(Long id,User user);

    User getUserById(Long userId);

    List<Article> getUserArticles(Long userId);

    List<ArticleFavorite> getUserArticleFavorites(Long userId);

    List<UserFollow> getUserFollow(Long userId);
    List<User> getUsers();

}
