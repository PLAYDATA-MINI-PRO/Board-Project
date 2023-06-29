package com.board.controller;

import com.board.domain.dto.CommentDto;
import com.board.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // 겟은
    @GetMapping("/board/{id}")
    public ModelAndView showComment(
            @RequestParam(value = "commentlist", required = false) String commentlist
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/board/{id}");

        if (commentlist != null && !commentlist.equals("")) {
            List<CommentDto> byComment = commentService.addComment(commentlist);
            modelAndView.addObject("commentlist", byComment);
        } else {
            modelAndView.addObject("commentlist", commentService.findAll());
        }
        return modelAndView;
    }



//        modelAndView.addObject("todolist", commentService.findAll());
//        modelAndView.setViewName("/comment");
//
//
////         투두 리스트 가져다 줘야하고
//        return modelAndView;
//    }

    @PostMapping("/board/{id}")
    public ModelAndView inputComment(
            ModelAndView mav,
            @PathVariable("id") Integer bid,
            @RequestParam("content") String content,
            @RequestParam("username") String username,
            HttpSession session
    ) {
        // TODO insert 서비스 에다가 만들거다.
        if(commentService.addComment(bid, content, username) != 0)
            mav.setViewName("redirect:/board/");
        else {
//            mav.setViewName("redirect:/main?err=not_insert");
            mav.setViewName("redirect:/board");
            mav.addObject("err", "not_insert");
        }
        return mav;


    }

}
