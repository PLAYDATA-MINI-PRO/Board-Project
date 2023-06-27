package com.board.controller;

import com.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    // 의존성 주입
    private final BoardService boardService;

    // BoardService 를 주입받기 위한 생성자
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // GET 요청을 /board 경로로 처리
    @GetMapping("/board")
    public ModelAndView showBoard() {

        // ModelAndView: 컨트롤러 처리 결과 후 응답할 view 와 view 의 전달 값을 저장 및 전달하는 클래스
        ModelAndView modelAndView = new ModelAndView();

        // 응답할 view 이름을 /board/main 으로 지정
        modelAndView.setViewName("/board/main");

        // view에 모든 게시물 데이터를 boardList라는 값으로 전달
        modelAndView.addObject("boardList", boardService.findAll());
        return modelAndView;
    }

    @PostMapping("/board")
    public ModelAndView boardInsert(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("content") String content,
            @RequestParam("username") String username,
            ModelAndView mav,
            HttpSession session

    ) {

//        Integer id = (Integer) session.getAttribute("id");

        if (boardService.insert(title, category, content, username) != 0) {
            mav.setViewName("redirect:/board");
        }

        return mav;
    }

}

