package it.esotopo.blog.service.impl;

import it.esotopo.blog.conversionutils.ArticleToArticleDto;
import it.esotopo.blog.entity.Article;
import it.esotopo.blog.model.ArticleDto;
import it.esotopo.blog.model.exception.BadArticleException;
import it.esotopo.blog.model.reqres.req.GetArticleRequest;
import it.esotopo.blog.model.reqres.req.NewArticleRequest;
import it.esotopo.blog.model.res.GetArticleResponse;
import it.esotopo.blog.model.res.NewArticleResponse;
import it.esotopo.blog.repository.ArticleRepository;
import it.esotopo.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final String INVALID_ARTICLE = "Error during the creation of the new article, the request is not valid";
    private final String INVALID_REQUEST = "Error during retrieving article";
    private final String NO_TITLE = "No title was provided for new article";
    private final String NO_ARTICLE = "An insert article request was performed with no article";

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @Override
    public NewArticleResponse insertNewArticle(NewArticleRequest newArticleRequest) {
        NewArticleResponse newArticleResponse = new NewArticleResponse();

        try{
            validateArticle(newArticleRequest);
        }catch (BadArticleException e){
            log.error(e.getMessage());
            newArticleResponse.getErrors().add(e);
            return newArticleResponse;
        }

        ArticleDto articleDto = newArticleRequest.getArticle();

        Article article = new Article();

        article.setTitle(articleDto.getTitle());
        article.setDate(new Date());
        article.setHtmlContent(articleDto.getHtmlContent());

        Article savedArticle = articleRepository.save(article);

        ArticleDto finalArticle = ArticleToArticleDto.convert(savedArticle);

        newArticleResponse.setArticle(finalArticle);

        return newArticleResponse;
    }

    private void validateArticle(NewArticleRequest newArticleRequest) throws BadArticleException{
        if(newArticleRequest.getArticle() == null){
            throw new BadArticleException(NO_ARTICLE);
        }
    }

    @Override
    public Optional<Article> findArticleByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    @Override
    public Article saveOrUpdateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public GetArticleResponse getArticleByTitle(GetArticleRequest getArticleRequest) {
        GetArticleResponse getArticleResponse = new GetArticleResponse();

        ArticleDto articleDto = null;

        try{
            validateArticleRequest(getArticleRequest);
        }catch (BadArticleException e){
            log.error(e.getMessage());
            getArticleResponse.getErrors().add(e);
            return getArticleResponse;
        }

        String title = getArticleRequest.getTitle();

        Optional<Article> article = findArticleByTitle(title);

        if(article.isPresent()){
            articleDto = ArticleToArticleDto.convert(article.get());
        }

        getArticleResponse.setArticleDto(articleDto);

        return getArticleResponse;
    }

    private void validateArticleRequest(GetArticleRequest getArticleRequest) throws BadArticleException{
        String title = getArticleRequest.getTitle();

        if(title == null){
            throw new BadArticleException(NO_TITLE);
        }
    }
}
