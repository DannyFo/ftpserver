package com.fomin.ftpServer.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping("/hello")
    public String sayhello(){
        return "Hello World";
    }
}
