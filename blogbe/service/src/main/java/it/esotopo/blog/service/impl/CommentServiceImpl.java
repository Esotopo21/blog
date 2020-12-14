package it.esotopo.blog.service.impl;

import it.esotopo.blog.entity.Article;
import it.esotopo.blog.entity.Comment;
import it.esotopo.blog.model.CommentDto;
import it.esotopo.blog.model.exception.BadCommentException;
import it.esotopo.blog.model.reqres.req.NewCommentRequest;
import it.esotopo.blog.model.res.NewCommentResponse;
import it.esotopo.blog.repository.CommentRepository;
import it.esotopo.blog.service.ArticleService;
import it.esotopo.blog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ArticleService articleService;

    private final String NO_TARGET_ARTICLE = "No article was found with given title: %s";

    public CommentServiceImpl(CommentRepository commentRepository, ArticleService articleService) {
        this.commentRepository = commentRepository;
        this.articleService = articleService;
    }

    @Override
    @Transactional
    public NewCommentResponse insertNewCommentOnArticle(NewCommentRequest newCommentRequest) {
        NewCommentResponse newCommentResponse = new NewCommentResponse();

        Article targetArticle;

        try{
            targetArticle = validateCommentRequestAndGetArticle(newCommentRequest);
        }catch (BadCommentException e){
            log.error(e.getMessage());
            newCommentResponse.getErrors().add(e);
            return newCommentResponse;
        }

        Comment comment = new Comment();
        CommentDto commentDto = newCommentRequest.getComment();

        comment.setHtmlContent(commentDto.getHtmlContent());
        comment.setAuthor(commentDto.getAuthor());
        comment.setDate(new Date());
        comment.setArticle(targetArticle);

        Comment savedComment = commentRepository.save(comment);

        targetArticle.getComment().add(savedComment);

        articleService.saveOrUpdateArticle(targetArticle);

        return newCommentResponse;
    }

    private Article validateCommentRequestAndGetArticle(NewCommentRequest newCommentRequest) throws BadCommentException {
        String targetArticleTitle = newCommentRequest.getArticleTitle();
        Optional<Article> targetArticle = articleService.findArticleByTitle(targetArticleTitle);

        if (targetArticle.isPresent()){
            return targetArticle.get();
        }else{
            throw new BadCommentException(String.format(NO_TARGET_ARTICLE, targetArticleTitle));
        }
    }
}
