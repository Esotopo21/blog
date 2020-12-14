package it.esotopo.blog.model.exception;

import lombok.Data;

@Data
public class GenericException extends Exception{

    public GenericException(){

    }

    public GenericException(String message){
        this.message = message;
    }

    public GenericException(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    private String errorCode;
    private String message;

}
