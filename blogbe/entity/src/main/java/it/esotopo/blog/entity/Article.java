package it.esotopo.blog.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Article {

    public Article(){
        this.comment = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String title;
    private Date date;
    @Lob
    private String htmlContent;
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<Comment> comment;

}
