package com.abdala.demo;

import com.abdala.demo.entity.User;
import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.repository.ArticleCommentRepo;
import com.abdala.demo.repository.UserRepo;
import com.abdala.demo.repository.ArticleRepo;
//import com.abdala.demo.repository.ArticleCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ArticleRepo articleRepository;
    @Autowired
    private ArticleCommentRepo articleCommentRepository;

    @Override
    public void run(String... args) throws Exception {
        // Delete all existing data
        articleCommentRepository.deleteAll();
        articleRepository.deleteAll();
        userRepository.deleteAll();


        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            User user = new User("User" + i, "user" + i + "@example.com");
            user.setPassword("password123");
            user.setBio("Bio for User" + i);
            user.setCreatedAt(LocalDateTime.now());
            users.add(user);
        }
        userRepository.saveAll(users);


        List<Article> articles = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 40; i++) {
            Article article = new Article(
                    "Article" + i,
                    "article" + i,
                    "Content for Article" + i,
                    "Description for Article" + i,
                    users.get(random.nextInt(users.size())) // Random author
            );
            article.setCreatedAt(LocalDateTime.now());
            articles.add(article);
        }
        articleRepository.saveAll(articles);

//        List<ArticleComment> comments = new ArrayList<>();
//        for (int i = 1; i <= 40; i++) {
//            ArticleComment comment = new ArticleComment(
//                    "Comment" + i + " for Article" + i,
//                    articles.get(random.nextInt(articles.size())), // Random article
//                    users.get(random.nextInt(users.size())) // Random author
//            );
//            comment.setCreatedAt(LocalDateTime.now());
//            comments.add(comment);
//        }
//        articleCommentRepository.saveAll(comments);


        for (int i = 0; i < 40; i++) {
            User follower = users.get(i);
            User followed = users.get((i + 1) % users.size()); // Follow the next user (circular)
            follower.followUser(followed);
        }
        userRepository.saveAll(users);
    }
}
