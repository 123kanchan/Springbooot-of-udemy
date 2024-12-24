package com.udemycourse.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //@Controller + @ResponseBosy
public class HelloWorldController {
//HTTP Ger request

    @GetMapping("/hello-world")
    public String helloworld(){
        return "hello";
    }
}
