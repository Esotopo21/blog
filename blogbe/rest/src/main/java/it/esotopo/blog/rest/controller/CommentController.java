package it.esotopo.blog.rest.controller;

import it.esotopo.blog.model.reqres.req.NewCommentRequest;
import it.esotopo.blog.model.res.NewCommentResponse;
import it.esotopo.blog.service.CommentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public NewCommentResponse addComment(@RequestBody NewCommentRequest newCommentRequest){
        return commentService.insertNewCommentOnArticle(newCommentRequest);
    }
}
