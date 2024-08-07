package com.study.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.dto.Board;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

	//@autowired를 붙이면 자동으로  해당 인터페이스를 구현한 클래스의 객체를 가져온다.
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "redirect:list";
	}
	
	/*
	 * 요청 처리 후 응답페이지로 포워딩 또는 url재요청시 응답 데이터를 담는 방법
		1. Model 객체
		   포워딩할 뷰로 전달하고자하는 데이터를 맵형식<key, value>로 담을 수 있는 영역
		   이전에 할때는 requestScope영역을 이용해 setAttribute로 담았는데 여기서는 살짝 다름
		   똑같이 requestScope이긴하지만  
		   **단, setAttribute가 아닌 addAttribute메소드 이용
		2. ModelAndView
		   Model은 데이터를 맵형식<key,value>로 담을 수 있는 영역(데이터를 담는영역)
		   view는 응답뷰에 대한 정보를 담을 수 있는 공간(이동할 주소를 담는 영역)
	*/
	@RequestMapping("/list")
	public String userListPage(Model model) {
		model.addAttribute("totalRecord", boardService.totalRecord());
		List <Board> list =boardService.list();
		System.out.println(list.size());
		model.addAttribute("RecordList",list);
		return "list";
	}

	/*
		요청시 전달한값(파라메터)를 받는 방법
		1. HttpServletRequest를 이용하여 전달받는 방법
		   메서드의 매개변수에 넣는방법
		   ex) 메서드 : 반환형 메서드명(HttpServletRequest 매개변수명)
		   
	    2. @RequestParam 어노테이션을 사용하는 방법
	       메서드 위에 어노테이션을 넣는 방법
	       - 변수에 저장할 떄 : request.getParameter("key")
	       
   		3. 메서드 매개변수에 직접 이름(전달한 키와 동일한 이름)을 넣어줌
   		(전달받은 request의 키값을 매개변수에 넣는방법, 전달받은 request의 갯수와 똑같이 매개변수의 갯수를 지정해줘야함)
   		  
	*/
	
	// 1. HttpServlet
/*	@RequestMapping("/detail")
	public String detailView(HttpServletRequest r) {
		String boardNo=r.getParameter("boardno");
		return "detail";
	}
*/
	
	// 2. @RequestParam
/*	@RequestMapping("/detail")
	public String detailView(@RequestParam(value="boardno") String bno,
							 @RequestParam(value="writer", defaultValue="홍길동") String w) {
		
		return "detail";
	}
	//장점 : defaultValue가 있어서 값이 없을떄 디폴트 값을 설정해둘 수 있다.
*/
	
	// 3. @RequestParam 3번은 되지 않음
/*	@RequestMapping("/detail")
	public String detailView(String boardno, String writer) {
		//반드시 앞에서 넘겨준 키값과 동일하게 변수이름을 넣어야함. default사용 불가
		return "detail";
	}
*/	
	
	@RequestMapping("/detail")
	public String detailView(@RequestParam("boardno") String boardno,
							 @RequestParam(value="writer", defaultValue="홍길동") String w,
							 Model model) {
		Board bean = boardService.detailBoard(boardno);
		model.addAttribute("detailBoard", bean);
		
		return "detail";
	
	}
	Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping("/delete")
	public String deleteBoard(HttpServletRequest r) {
		String boardno = r.getParameter("boardno");
		int result = boardService.deleteBoard(boardno);
		System.out.println("delete Result : "+result);
		if(result==1) {
			
			return "redirect:list";
		}else {
			LOGGER.warn("delete 실패");
			return "detail";
		}
	}
	@RequestMapping("/writerForm")
	public String writerForm() {
		return"writeForm";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		String title=request.getParameter("title");
		String writer=request.getParameter("writer");
		String content=request.getParameter("content");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", title);
		map.put("writer", writer);
		map.put("content", content);
		int result =boardService.insertBoard(map);
		System.out.println(result);
		if(result==1) {
			
			return "redirect:list";
		}else {
			LOGGER.warn("insert 실패");
			return "writerForm";
		}
		
	}
}












