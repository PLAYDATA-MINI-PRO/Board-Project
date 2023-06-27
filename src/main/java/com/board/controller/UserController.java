package com.board.controller;

import com.board.domain.requset.SignupRequest;
import com.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserService userService;

    @GetMapping("/user/signup")
    public String signupGet(){
        return "/user/signup";
    }
    @PostMapping("/user/signup")
    public ModelAndView signupPost(@ModelAttribute SignupRequest signupRequest,ModelAndView mv){
        if(userService.signup(signupRequest)){
            mv.setViewName("redirect:/user/login");
        }
        else {
         mv.setViewName("redirect:/user/signup");
        }
        return mv;
    }

}
