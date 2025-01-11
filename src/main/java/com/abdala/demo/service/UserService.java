package com.abdala.demo.service;



import com.abdala.demo.entity.Article;
//import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
//import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateUserDTO;
import com.abdala.demo.service.dto.UpdateUserDTO;
import com.abdala.demo.service.dto.UserDTO;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    public void followUser(Long followerId, Long followedId);
    public void unFollowUser(Long followerId, Long followedId);
    List<UserDTO> getFollowers(Long followerId);

    UserDTO createUser(CreateUserDTO teacherRequest);

    void deleteUser(Long userId);

    UserDTO  updateUser(Long id, UpdateUserDTO user);

    UserDTO getUserById(Long userId);

    List<ArticleDTO> getUserArticles(Long userId);




    //  List<ArticleDTO> getUserArticles(Integer userId);

   // List<ArticleDTO> getUserArticleFavorites(Integer userId);

    //List<UserDTO> getUserFollow(Integer userId);



}
