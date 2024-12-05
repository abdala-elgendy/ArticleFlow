package com.abdala.demo.repository;

import com.abdala.demo.entity.Article;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Integer> {

//    @Query("SELECT a FROM Article a  WHERE a.tagName = :tagName")
//    List<Article> findArticlesByTagName(@Param("tagName") String tagName);
//
//  @Query("select a from Article a join User x where x.id=:authorId")
//    List<Article> findByAuthorId(Long authorId);
//
//    List<Article> findFavoriteArticlesByUserId(Long userId);


}
