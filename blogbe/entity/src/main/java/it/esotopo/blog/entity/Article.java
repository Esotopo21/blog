package it.esotopo.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Article {

    @Id
    private Long id;
    private String title;
    private Date date;
    @Lob
    private String htmlContent;
    @OneToMany
    private List<Comment> comment;

}
