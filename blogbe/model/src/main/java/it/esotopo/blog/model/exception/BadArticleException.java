package it.esotopo.blog.model.exception;

import lombok.Data;

@Data
public class BadArticleException extends GenericException{

    public BadArticleException(String message){
        super("BadArticleException", message);
    }

}
