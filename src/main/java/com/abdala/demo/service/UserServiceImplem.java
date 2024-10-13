package com.abdala.demo.service;

import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleFavorite;
import com.abdala.demo.entity.User;
import com.abdala.demo.entity.UserFollow;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.service.dto.UserDTO;
import com.abdala.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImplem implements UserService{

      @Autowired
    private UserRepo userRepo ;

    @Autowired

    private UserMapper userMapper;

    @Override
    public UserDTO createUser(User user) {
     return userRepo.save(user);
        ///     return userRepo.save(user);

    }



    @Override
    public void deleteUser(Long userId) {
   userRepo.deleteById(userId);
    }




    @Override
    public User updateUser(Long id,User user) {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setBio(user.getBio());

            return userRepo.save(updatedUser);
        }
        throw new RuntimeException("User not found with id: " + id);
    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }

    @Override
    public List<Article> getUserArticles(Long userId) {
        return List.of();
    }

    @Override
    public List<ArticleFavorite> getUserArticleFavorites(Long userId) {
        return List.of();
    }

    @Override
    public List<UserFollow> getUserFollow(Long userId) {
        return List.of();
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }
}
