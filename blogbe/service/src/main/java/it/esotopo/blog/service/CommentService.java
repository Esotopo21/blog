package it.esotopo.blog.service;

import it.esotopo.blog.model.reqres.req.NewCommentRequest;
import it.esotopo.blog.model.res.NewCommentResponse;

public interface CommentService {

    public NewCommentResponse insertNewCommentOnArticle(NewCommentRequest newCommentRequest);

}
