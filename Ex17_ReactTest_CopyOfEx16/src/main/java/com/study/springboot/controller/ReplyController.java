package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Member;
import com.study.springboot.domain.Reply;
import com.study.springboot.service.ReplyService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("loginUser")
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@GetMapping("/replyInsert")
	public @ResponseBody List<Reply> replyInsert(HttpSession session, 
			@RequestParam("refBno") Long refBno, 
			@RequestParam("content") String content) {
		List<Reply> error = new ArrayList<Reply>();
		
		try {
			String writer = ((Member)session.getAttribute("loginUser")).getId();
			Reply r = new Reply(content, writer,refBno);
			System.out.println("insertReply refBno : "+r.getRefBno());
			System.out.println("insertReply r : "+r);
			replyService.insertReply(r);
			return replyList(refBno);
		}catch(NullPointerException e) {
			System.out.println("nullpointer");
			error.add(new Reply("loginRequired"));
			return error;
		}
		
	}
	
	@GetMapping("/replyList")
	public @ResponseBody List<Reply> replyList(@RequestParam("refBno") Long refBno) {
		System.out.println("replyList refBno : "+refBno);
		List<Reply> rList = replyService.selectAllReply(refBno);
		System.out.println("replyList list : "+rList);
		return rList;
	}

}
