package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Raven
 */
@RestController
public class InitController {

    @RequestMapping("/index")
    public String sayHello(){
        return "hello index";
    }
}
