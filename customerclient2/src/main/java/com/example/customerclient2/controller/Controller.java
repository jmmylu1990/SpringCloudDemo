package com.example.customerclient2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/load")
    public String load() {
        return "load";
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World";
    }
}
