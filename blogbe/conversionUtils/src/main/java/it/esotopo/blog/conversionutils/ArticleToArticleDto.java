package it.esotopo.blog.conversionutils;

import it.esotopo.blog.entity.Article;
import it.esotopo.blog.model.ArticleDto;

import java.util.stream.Collectors;

public class ArticleToArticleDto {

    public static ArticleDto convert(Article article){
        ArticleDto articleDto = new ArticleDto();

        articleDto.setTitle(article.getTitle());
        articleDto.setDate(article.getDate());
        articleDto.setHtmlContent(article.getHtmlContent());
        articleDto.setComments(article.getComment().stream().map(CommentToCommentDto::convert).collect(Collectors.toList()));

        return articleDto;
    }

}
