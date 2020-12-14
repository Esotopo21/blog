package it.esotopo.blog.repository;

import it.esotopo.blog.entity.Article;
import it.esotopo.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Set<Comment> findAllByArticle(Article article);

}
