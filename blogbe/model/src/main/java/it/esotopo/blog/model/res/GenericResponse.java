package it.esotopo.blog.model.res;

import it.esotopo.blog.model.exception.GenericException;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class GenericResponse {

    List<GenericException> errors = new ArrayList<>();

}
