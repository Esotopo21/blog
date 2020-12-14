package it.esotopo.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private Date date;
    @Lob
    private String htmlContent;
    @ManyToOne
    private Article article;

}
