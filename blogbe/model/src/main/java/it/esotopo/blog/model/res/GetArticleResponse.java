package it.esotopo.blog.model.res;

import it.esotopo.blog.model.ArticleDto;
import it.esotopo.blog.model.exception.GenericException;
import lombok.Data;

@Data
public class GetArticleResponse extends GenericResponse {

    ArticleDto articleDto;

}
