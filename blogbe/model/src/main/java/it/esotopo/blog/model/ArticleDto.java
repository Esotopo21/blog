package it.esotopo.blog.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ArticleDto {

    public ArticleDto(){
        this.comments = new ArrayList<>();
    }

    private String title;
    private Date date;
    private String htmlContent;
    private List<CommentDto> comments;

}
