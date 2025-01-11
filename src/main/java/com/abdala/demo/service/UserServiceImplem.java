package com.abdala.demo.service;

import com.abdala.demo.entity.Article;
//import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
//import com.abdala.demo.entity.UserFollow;
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
import java.util.Set;
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
    public void followUser(Long followerId, Long followedId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + followerId));
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + followedId));
        follower.followUser(followed);
        userRepository.save(follower);
    }

    @Override
    public void unFollowUser(Long followerId, Long followedId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + followerId));
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + followedId));
        follower.unfollowUser(followed);
        userRepository.save(follower);
    }

    @Override
    public List<UserDTO> getFollowers(Long followerId) {
        List<User> followers = userRepository.findFollowersByUserId(followerId);

        return followers.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public UserDTO createUser(CreateUserDTO teacherRequest) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserDTO user) {
        return null;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return null;
    }

    @Override
    public List<ArticleDTO> getUserArticles(Long userId) {
        return List.of();
    }


}









