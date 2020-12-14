package it.esotopo.blog.model.exception;

public class BadCommentException extends GenericException{

    public BadCommentException(String message){
        super("BadCommentException", message);
    }

}
