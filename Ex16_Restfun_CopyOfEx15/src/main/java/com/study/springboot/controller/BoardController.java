package com.study.springboot.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SessionAttributes("loginUser")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	private Member loginUser;
	@GetMapping("/list")
	public String boardList(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Model model, @RequestParam(value="keyField", required=false) String keyField,@RequestParam(value="keyWord", required=false) String keyWord) {
		Page<Board> pageList=null;
		if(keyWord == null) {
			System.out.println("boardList keyWord : "+keyWord +"keyField : "+ keyField);
			pageList = 
					boardService.list(PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC,"bno")));
		}else {
			keyWord="%"+keyWord+"%";
			switch(keyField) {
			case "title" : 
				pageList = 
				boardService.searchListByTitleLike(PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC,"bno")), keyWord);
				break;
			case "writer":
				pageList = 
				boardService.searchListByWriterLike(PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC,"bno")), keyWord);
				break;
			case "content" :
				pageList = 
				boardService.searchListByContentLike(PageRequest.of(nowPage, 5, Sort.by(Sort.Direction.DESC,"bno")), keyWord);
				break;
			}
		}
		
		
		int pagePerBlock=5;		//[1][2][3][4][5]
		int endPage = Math.min(pageList.getTotalPages(), nowPage + pagePerBlock);
		// [1][2][3][4][5] ...이었다가   ... [2][3][4][5][6] ...으로 보이도록 하는 계산
		model.addAttribute("boardPage", pageList);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("endPage", endPage);
		
		return "board/list";
	}
	
	
	@GetMapping("/insertForm")
	public String insertForm(Model m) {
		m.addAttribute("title", "글 쓰 기");
		m.addAttribute("action", "insert");
		return "board/insertForm";
	}
	@GetMapping("/updateBoard")
	public String updateBoard(@RequestParam("bno") Long bno, Model m) {
		System.out.println("bno : "+bno);
		Board b =boardService.selectById(bno).get();
		System.out.println("updateBoard Board b : "+b);
		m.addAttribute("title", "글 수정");
		m.addAttribute("board", b);
		m.addAttribute("action", "update");
		return "board/insertForm";
	}
	
	@PostMapping("/insert")
	public String isertBoard(Board b, Model m) {
		boardService.insertBoard(b);
	
		return  boardList(0,m, null, null);
	}
	@PostMapping("/update")
	public String updateBoard(Board updateB,@RequestParam Long update, Model model) {
		Board b = boardService.selectById(update).get();
		
		b.setTitle(updateB.getTitle());
		b.setContent(updateB.getContent());
		boardService.insertBoard(b);
		model.addAttribute("board", b);
		return boardList(0,model, null, null);
	}
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam("bno") Long bno, Model model, HttpSession session) {
		Optional<Board> b = boardService.selectById(bno);
		Board board=boardService.updateCount(b.get());
		
		model.addAttribute("board", board);
		session.setAttribute("boardDetailUrl", "/detailForm?bno="+ bno);
		return "board/boardDetail";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam("bno") Long bno, Model m) {
		System.out.println("bno : "+bno);
		boardService.deleteBoard(bno);
		return boardList(0,m, null, null);
		
	}
	
	@GetMapping("/memberAuthorize")
	public @ResponseBody int Authorize(HttpServletRequest r , @RequestParam("writer") String writer){
		try {
		HttpSession session = r.getSession();
		Member user = (Member)session.getAttribute("loginUser");
		if(!user.getId().equals((String)writer)) {
			System.out.println(222222);
			return -1;
		}
		}catch(NullPointerException e) {
			return -1;
		}
		return 0;
	}
	
	
	
	
	
	
	
	
}
