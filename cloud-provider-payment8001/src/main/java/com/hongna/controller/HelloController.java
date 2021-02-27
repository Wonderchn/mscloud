package com.hongna.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/xixi")
    public String  sayhello(){
        return "fuckyou";
    }
}
