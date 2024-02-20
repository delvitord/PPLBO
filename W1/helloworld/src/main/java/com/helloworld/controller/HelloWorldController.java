package com.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    @ResponseBody
    public String getIndex(){

        return "<h1>Hello World</h1>";
    }
}



