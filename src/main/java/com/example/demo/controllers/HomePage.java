package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePage {
    private final String HELLO = "Hello world!";

    @GetMapping("/")
    public String sayHello() {
        return  HELLO;
    }
}
