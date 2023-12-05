package com.example.board.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.board.repository.BBoardRepository;
import com.example.board.model.BBoard;

@Controller
public class BoardController {
    @Autowired
    BBoardRepository bBoardRepository;
    
    @GetMapping("bboard/list")
    public String a(){
      return "test/board";  
    }
    @GetMapping("/bboard/insertpage")
    public String c(){
       return "test/boardpage";
    }
    @GetMapping("bboard/insert")
    public String b(@RequestParam("title") String title,
                    @RequestParam("content") String content,
                    Model model){
        BBoard bBoard = new BBoard();
        int seq = bBoardRepository.findAll().size()+1;
        bBoard.setTitle(title);
        bBoard.setContent(content);
        bBoard.setSeq(seq);
        
        bBoardRepository.save(bBoard);

        model.addAttribute("a1", title);
        model.addAttribute("a2", content);
        model.addAttribute("cnt", seq);
        model.addAttribute("board", bBoardRepository.findAll());

        return "test/board"; 
    }
  }