package com.board.controller;

import com.board.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService, CommentService commentService1) {
        this.commentService = commentService1;
    }

    // 겟은
    @GetMapping("/comment")
    public ModelAndView showComment() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("todolist", commentService.findAll());
        modelAndView.setViewName("/comment");


//         투두 리스트 가져다 줘야하고
        return modelAndView;
    }

    @PostMapping("/comment")
    public ModelAndView inputComment(
            ModelAndView mav,
            HttpSession session
    ) {
        Integer id = (Integer) session.getAttribute("id");
        // TODO insert 서비스 에다가 만들거다.

        if(id != null && commentService.addComment(boardId, content, username) != 0)
            mav.setViewName("redirect:/comment");
        else {
//            mav.setViewName("redirect:/main?err=not_insert");
            mav.setViewName("redirect:/comment");
            mav.addObject("err", "not_insert");
        }
        return mav;

    return null;
    }

}
