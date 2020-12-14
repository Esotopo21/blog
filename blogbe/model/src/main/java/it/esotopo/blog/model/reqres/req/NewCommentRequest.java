package it.esotopo.blog.model.reqres.req;

import it.esotopo.blog.model.CommentDto;
import lombok.Data;

@Data
public class NewCommentRequest {

    private CommentDto comment;
    private String articleTitle;

}
