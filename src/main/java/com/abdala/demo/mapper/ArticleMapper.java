package com.abdala.demo.mapper;

import com.abdala.demo.dto.ArticleCommentDTO;
import com.abdala.demo.entity.Article;
import com.abdala.demo.dto.ArticleDTO;
import com.abdala.demo.dto.CreateArticleDTO;
import com.abdala.demo.entity.ArticleComment;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public ArticleDTO toDTO(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setDescription(article.getDescription());
        dto.setContent(article.getContent());
        dto.setCreatedAt(article.getCreatedAt());
        dto.setTagName(article.getTagName());
        dto.setSlug(article.getSlug());
        return dto;
    }

    public Article toEntity(CreateArticleDTO createArticleDTO) {
        Article article = new Article();
        article.setTitle(createArticleDTO.getTitle());
        article.setDescription(createArticleDTO.getDescription());
        article.setContent(createArticleDTO.getContent());
        article.setTagName(createArticleDTO.getTagName());

        return article;
    }

    public ArticleCommentDTO toDTO(ArticleComment articleComment) {
        ArticleCommentDTO dto = new ArticleCommentDTO();
        dto.setArticleId(articleComment.getArticle().getId());
        dto.setContent(articleComment.getContent());
        dto.setAuthor(articleComment.getAuthor().getUsername());
        dto.setCreatedAt(articleComment.getCreatedAt());
        return dto;
    }

}
