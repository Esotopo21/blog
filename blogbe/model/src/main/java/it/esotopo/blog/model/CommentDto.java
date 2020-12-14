package it.esotopo.blog.model;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    private String author;
    private Date date;
    private String htmlContent;
    
}
