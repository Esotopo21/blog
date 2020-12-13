package it.esotopo.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Entity
public class Comment {

    @Id
    private Long id;
    private String author;
    @Lob
    private String htmlContent;



}
