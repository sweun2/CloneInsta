package com.clone.insta.controller;

import com.clone.insta.domain.UserInfo;
import com.clone.insta.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private  final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

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

    @GetMapping("/join")
    public String createForm(){return "createUsersForm";}

    @PostMapping("/join")
    public String create(UserForm form){
        UserInfo user= new UserInfo();
        user.setName(form.getName());

        userService.join(user);

        return "redirect:/";
    }

}
