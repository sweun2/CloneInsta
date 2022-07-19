package com.clone.insta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "main.html";
    }

    @GetMapping("/index")
    public String index(){
        return "index.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/main")
    public String main(){
        return home();
    }
}
