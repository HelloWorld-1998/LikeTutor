package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
@RestController
public class HelloController {
    @RequestMapping("/")
    public String helloWorld(){
        return "hello my first program";
    }
}
