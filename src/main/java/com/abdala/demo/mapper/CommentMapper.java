package com.abdala.demo.mapper;

import com.abdala.demo.dto.ArticleCommentDTO;
import com.abdala.demo.entity.ArticleComment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public ArticleCommentDTO toDTO(ArticleComment comment) {


        ArticleCommentDTO dto = new ArticleCommentDTO();

        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setArticleId(comment.getArticle().getId());
        dto.setAuthor(comment.getAuthor().getUsername());
        return dto;
}
   public ArticleComment toEntity(ArticleCommentDTO createCommentDTO) {
       ArticleComment comment = new ArticleComment();
        comment.setContent(createCommentDTO.getContent());

        return comment;

}}
