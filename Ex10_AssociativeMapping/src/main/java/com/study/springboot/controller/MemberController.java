package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/minsert")
	public String minsert(Member m, Model model) {
		Member member = memberService.minsert(m);
		model.addAttribute("member",member);
		model.addAttribute("title","등록");
		return "mResult";
	}
	
	@RequestMapping("/mupdate")
	public String mupdate(String id, String name, String chPWD, String checkPWD, Model model) {
		
		Optional<Member> rMember = memberService.selectById(id);
		if(!rMember.isPresent()) {
			model.addAttribute("error",22);
			return "index";
		}
		Member m = rMember.get();
		if(chPWD.equals(checkPWD)) {
			m.setName(name);
			m.setPassword(chPWD);
			Member member=memberService.mupdate(m);
			model.addAttribute("member", member);
			model.addAttribute("title","수정");
			return "mResult";
		}else {
			model.addAttribute("error", 11);
			
			return "index";
		}
	}
}
