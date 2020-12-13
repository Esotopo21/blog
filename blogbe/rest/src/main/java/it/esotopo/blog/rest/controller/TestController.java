package it.esotopo.blog.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "greet", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greetings(){
        return "Hello world|";
    }

}
