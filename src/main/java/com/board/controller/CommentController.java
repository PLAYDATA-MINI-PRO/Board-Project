package com.board.controller;

import com.board.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService, CommentService commentService1) {
        this.commentService = commentService1;
    }
}
// 겟은
    @GetMapping("/comment")
    public ModelAndView showMain(@RequestParam(value = "board_id") String board_id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/comment");
        modelAndView.addObject("todolist", commentService.findAll());

//         투두 리스트 가져다 줘야하고
        return modelAndView;
    }

    @PostMapping("/main")
    public ModelAndView inputdata(
            @RequestParam("content") String content,
            ModelAndView mav,
            HttpSession session
    ){
        Integer id = (Integer) session.getAttribute("id");
        // TODO insert 서비스 에다가 만들거다.

        if(id != null && todoService.insert(id,content) != 0)
            mav.setViewName("redirect:/main");
        else {
//            mav.setViewName("redirect:/main?err=not_insert");
            mav.setViewName("redirect:/main");
            mav.addObject("err", "not_insert");
        }
        return mav;

    }
}
