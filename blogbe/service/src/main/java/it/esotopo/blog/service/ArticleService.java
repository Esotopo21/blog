package it.esotopo.blog.service;

import it.esotopo.blog.entity.Article;
import it.esotopo.blog.model.ArticleDto;
import it.esotopo.blog.model.reqres.req.GetArticleRequest;
import it.esotopo.blog.model.reqres.req.NewArticleRequest;
import it.esotopo.blog.model.res.GetArticleResponse;
import it.esotopo.blog.model.res.NewArticleResponse;

import java.util.Optional;
import java.util.Set;

public interface ArticleService {

    public NewArticleResponse insertNewArticle(NewArticleRequest newArticleRequest);
    public Optional<Article> findArticleByTitle(String title);
    public Article saveOrUpdateArticle(Article article);
    public GetArticleResponse getArticleByTitle(GetArticleRequest getArticleRequest);

}
