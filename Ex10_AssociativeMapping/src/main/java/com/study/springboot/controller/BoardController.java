package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;
import com.study.springboot.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/binsert")
	public String bInsert(Board board, Model model) {
		Member m = new Member();	
		m.setId("user02");			//세션에서 id를 가져왔다
		
		board.setMember(m);
		
		Board b = boardService.binsert(board);
		model.addAttribute("board", b);
		return "binsert";
	}
	
	
	
}

