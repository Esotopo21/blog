package it.esotopo.blog.conversionutils;

import it.esotopo.blog.entity.Comment;
import it.esotopo.blog.model.CommentDto;

public class CommentToCommentDto {

    public static CommentDto convert(Comment comment){
        CommentDto commentDto = new CommentDto();

        commentDto.setAuthor(comment.getAuthor());
        commentDto.setHtmlContent(comment.getHtmlContent());
        commentDto.setDate(comment.getDate());

        return commentDto;
    }
}
