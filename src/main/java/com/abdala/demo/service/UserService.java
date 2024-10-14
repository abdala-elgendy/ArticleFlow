package com.abdala.demo.service;



import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateUserDTO;
import com.abdala.demo.service.dto.UpdateUserDTO;
import com.abdala.demo.service.dto.UserDTO;


import java.util.List;

public interface UserService {

    void followUser(Long userId, Long followUserId);
    void unfollowUser(Long userId, Long unfollowUserId);

    UserDTO createUser(CreateUserDTO teacherRequest);

    void deleteUser(Long userId);

    UserDTO  updateUser(Long id, UpdateUserDTO user);

    UserDTO getUserById(Long userId);

    List<ArticleDTO> getUserArticles(Long userId);

    List<ArticleDTO> getUserArticleFavorites(Long userId);

    List<UserDTO> getUserFollow(Long userId);



}
