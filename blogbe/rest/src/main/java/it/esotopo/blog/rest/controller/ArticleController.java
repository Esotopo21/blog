package it.esotopo.blog.rest.controller;

import it.esotopo.blog.model.reqres.req.GetArticleRequest;
import it.esotopo.blog.model.reqres.req.NewArticleRequest;
import it.esotopo.blog.model.res.GetArticleResponse;
import it.esotopo.blog.model.res.NewArticleResponse;
import it.esotopo.blog.service.ArticleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public NewArticleResponse add(@RequestBody NewArticleRequest newArticleRequest){
       return  articleService.insertNewArticle(newArticleRequest);
    }

    @GetMapping(value = "findByTitle/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetArticleResponse findByArticle(@PathVariable("title") String title){
        GetArticleRequest getArticleRequest = new GetArticleRequest();

        getArticleRequest.setTitle(title);

        return articleService.getArticleByTitle(getArticleRequest);
    }
}
