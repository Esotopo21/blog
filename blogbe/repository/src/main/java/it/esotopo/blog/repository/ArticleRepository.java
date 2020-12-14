package it.esotopo.blog.repository;

import it.esotopo.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public Optional<Article> findByTitle(String title);

}
