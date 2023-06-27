package com.lotto.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/signup")
    public String getSingup(){
        return "/user/signup";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "/user/login";
    }

    @PostMapping("/signup")
    public String signup(){
        return "";
    }

}
