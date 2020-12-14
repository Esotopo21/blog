package it.esotopo.blog.model.res;

import it.esotopo.blog.model.ArticleDto;
import lombok.Data;

@Data
public class NewArticleResponse extends GenericResponse{

    ArticleDto article;

}
