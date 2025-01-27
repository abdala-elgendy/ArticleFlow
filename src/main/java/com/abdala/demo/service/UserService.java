package com.abdala.demo.service;



//import com.abdala.demo.entity.ArticleFavorite;
//import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.dto.*;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserService {

    public void followUser(Long followerId, Long followedId);
    public void unFollowUser(Long followerId, Long followedId);
    List<UserDTO> getFollowers(Long followerId);

    String createUser(CreateUserDTO teacherRequest);

    void deleteUser(Long userId);

    UserDTO  updateUser(Long id, UpdateUserDTO user);

    UserDTO getUserById(Long userId);

    List<ArticleDTO> getUserArticles(Long userId);

    UserProfileDTO getUserProfile(Long userId);



    //  List<ArticleDTO> getUserArticles(Integer userId);

   // List<ArticleDTO> getUserArticleFavorites(Integer userId);

    //List<UserDTO> getUserFollow(Integer userId);



}
