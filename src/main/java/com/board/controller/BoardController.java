package com.board.controller;

import com.board.domain.dto.BoardDto;
import com.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/main")
    public ModelAndView showMain() {

        // ModelAndView: 컨트롤러 처리 결과 후 응답할 view 와 view 의 전달 값을 저장 및 전달하는 클래스
        ModelAndView modelAndView = new ModelAndView();

        // 응답할 view 이름을 /board/main 으로 지정
        modelAndView.setViewName("/board/main");

        // view에 모든 게시물 데이터를 boardList 라는 이름으로 값 전달
        modelAndView.addObject("boardList", boardService.findAll());
        return modelAndView;
    }

    @GetMapping("/board/list")
    public ModelAndView showBoard() {

        // ModelAndView: 컨트롤러 처리 결과 후 응답할 view 와 view 의 전달 값을 저장 및 전달하는 클래스
        ModelAndView modelAndView = new ModelAndView();

        // 응답할 view 이름을 /board/main 으로 지정
        modelAndView.setViewName("/board/boardListMain");

        // view에 모든 게시물 데이터를 boardList 라는 이름으로 값 전달
        modelAndView.addObject("boardList", boardService.findAll());
        return modelAndView;
    }

    @GetMapping("/board/create")
    public ModelAndView showBoardCreate() {

        // ModelAndView: 컨트롤러 처리 결과 후 응답할 view 와 view 의 전달 값을 저장 및 전달하는 클래스
        ModelAndView modelAndView = new ModelAndView();

        // 응답할 view 이름을 /board/main 으로 지정
        modelAndView.setViewName("/board/board");

        // view에 모든 게시물 데이터를 boardList 라는 이름으로 값 전달
//        modelAndView.addObject("boardList", boardService.findAll());
        return modelAndView;
    }

    @GetMapping("/board/{id}")
    public String showBoardDetail(@PathVariable("id") Integer id, Model model) {
        BoardDto boardDto = boardService.findBoardById(id);
        model.addAttribute("board", boardDto);
        return "/board/boardDetail";
    }

    @GetMapping("/board/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        BoardDto boardDto = boardService.findBoardById(id);
        model.addAttribute("board", boardDto);
        return "/board/boardEdit";
    }

    // POST 요청을 /board로 처리
    @PostMapping("/board/create")
    public ModelAndView boardInsert(
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("content") String content,
            @RequestParam("username") String username
    ) {
        ModelAndView mav = new ModelAndView();

        // 요청 파라미터 값들을 문자열로 받고,
        // 문자열로 받은 값들을 boardService.insert 메서드의 요소로 넘겨주고 데이터베이스에 insert
        // 반환값이 0이 아닌 경우에 게시판 목록을 보여주는 /board 경로로 이동
        if (boardService.insert(title, category, content, username) != 0) {
            mav.setViewName("redirect:/main");
        }

        return mav;
    }

    @PostMapping("/board/update")
    public ModelAndView boardUpdate(
            @RequestParam("id") Integer id,
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam("content") String content,
            ModelAndView mav) {
        if (boardService.update(title, category, content, id) != 0) {
            mav.setViewName("redirect:/board/" + id);
        }
        return mav;
    }

    @PostMapping("/board/delete/{id}")
    public ModelAndView boardDelete(@PathVariable("id") Integer id, ModelAndView mav) {
        if (boardService.delete(id) != 0) {
            mav.setViewName("redirect:/main");
        }
        return mav;
    }
}

