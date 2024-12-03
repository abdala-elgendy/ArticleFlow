package com.abdala.demo.service;

import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.repository.ArticleRepo;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateUserDTO;
import com.abdala.demo.service.dto.UpdateUserDTO;
import com.abdala.demo.service.dto.UserDTO;
import com.abdala.demo.service.mapper.ArticleMapper;
import com.abdala.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImplem implements UserService{

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ArticleRepo articleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public void followUser(Integer userId, Integer followUserId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        User followUser = userRepository.findById(followUserId)
                .orElseThrow(() -> new RuntimeException("User to follow not found"));

        // Assuming a many-to-many relation where a user can follow many users
        user.getFollowing().add(followUser);
        userRepository.save(user);
    }

    @Override
    public void unfollowUser(Integer userId, Integer unfollowUserId) {

    }

    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) {
        User user = userMapper.toEntity(createUserDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }



    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }




    @Override
    public UserDTO  updateUser(Integer id, UpdateUserDTO updateUserDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update user fields based on updateUserDTO
        user.setName(updateUserDTO.getName());
        user.setBio(updateUserDTO.getBio());
        user.setEmail(updateUserDTO.getEmail());

        // Save updated user
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        return null;
    }

//    @Override
//    public List<ArticleDTO> getUserArticles(Integer userId) {
//        List<Article> articles = articleRepository.findByAuthorId(userId);
//        return articles.stream()
//                .map(articleMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<ArticleDTO> getUserArticleFavorites(Integer userId) {
//        List<Article> favoriteArticles = articleRepository.findFavoriteArticlesByUserId(userId);
//        return favoriteArticles.stream()
//                .map(articleMapper::toDTO)
//                .collect(Collectors.toList());
//    }

    @Override
    public List<UserDTO> getUserFollow(Integer userId) {

        List<User> followedUsers = userRepository.findFollowedUsersByUserId(userId);
        return followedUsers.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }


}
