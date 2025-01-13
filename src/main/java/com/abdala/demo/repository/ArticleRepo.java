package com.abdala.demo.repository;

import com.abdala.demo.entity.Article;
import com.abdala.demo.entity.ArticleComment;
import com.abdala.demo.entity.User;
import com.abdala.demo.service.ArticleServiceImplem;
import com.abdala.demo.service.dto.ArticleDTO;
import com.abdala.demo.service.dto.CreateArticleDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepo extends JpaRepository<Article, Long> {

    @Query("SELECT a FROM Article a  WHERE a.tagName = :tagName")
    List<Article> findArticlesByTagName(@Param("tagName") String tagName);

    @Query("select a from Article a where a.author.id=:authorId")
    List<Article> findByAuthorId(Long authorId);


//    @Query("select x from Article a join User x on x.id=:authorId")
//   User getAuthorOfArticle(Long authorId);
    List<Article> findArticleByAuthorId(Long authorId);

    @Query("select ac from Article a left join ArticleComment ac " +
            "on a.id= :articleId")
    List<ArticleComment> findCommentsOfArticle(Long articleId);

    @Query("select ac from  Article ac " +
            "where ac.slug= :slug")
    Optional<Article> findBySlug(String slug);

    @Query("select ac from ArticleComment ac " +
            "where ac.id= :commentId")
   Optional<ArticleComment> getComment( Long commentId);
    // List<Article> findFavoriteArticlesByUserId(Long userId);


}
