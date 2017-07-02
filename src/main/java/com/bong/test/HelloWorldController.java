package com.bong.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    BoardRepository boardRepo;

    @Autowired
    BoardServiceImpl boardService;

    @RequestMapping("/helloWorld")
    @ResponseBody
    public Board helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");

        Board board = new Board();

        board.setTitle("title");
        board.setRegdate(new Date());

        return board;
        //return "helloWorld";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Board> list(Model model) {

        //boardRepo.save();

        return boardRepo.selectAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Board board) {

        boardRepo.save(board);

        return new Result(true);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Board update(@RequestParam("seq") Integer seq) {

        Board board = boardRepo.find(seq);

        boardRepo.update(board);

        return board;
    }

    @RequestMapping(value = "/saveAll", method = RequestMethod.POST)
    @ResponseBody
    public String saveAll(@RequestBody Board board) {

        boardService.saveAll(board);

        return "{\"result\":\"success saveAll\"}";
    }
}