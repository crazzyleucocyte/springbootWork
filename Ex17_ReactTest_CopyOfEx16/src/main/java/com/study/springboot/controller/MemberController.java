package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

import jakarta.servlet.http.HttpSession;

@SessionAttributes({"loginUser"})
@Controller
public class MemberController {
	
	
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/")
	public String root() {
		// thymeleaf에는 prefix와 subfix가 기본으로 달려있는데 
		// root 경로는 resourcess/template이고
		// subfix는 .html이다.
		return"index";
	}
	
	@GetMapping("/EnrollForm")
	public String enrollForm() {
		return "member/EnrollForm";
	}
	
	@GetMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam("id") String id) {
		
		boolean result=memberService.idCheck(id);
		return result;
	}
	@PostMapping("/memberInsert")
	public String memberInsert(Member m) {
		m.setPassword(passwordEncoder.encode(m.getPassword()));		//암호화하는 부분
		memberService.memberInsert(m);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(Member m, Model model) {
		Optional<Member> loginUser=memberService.login(m);
		if(loginUser.isPresent()) {
			Member member = loginUser.get();
			if(passwordEncoder.matches(m.getPassword(), member.getPassword())) {
				member.setId(m.getId());
				model.addAttribute("loginUser", member);			//@SessionAttributes({"loginUser"})를 써서 requestScope에서 sessionScope로 변경
				return "redirect:/";
			}
		}
		String url = (String)session.getAttribute("boardDetailUrl");
		if(url == null) {
			url = "/"; 
		}
		return "redirect:"+url;
	}
	
	/*
		@SessionAttribute + model을 통해 로그인정보를 관리하는 경우
		  SessionStatus객체를 통해 사용완료 처리해야 한다.
		  - session객체를 폐기하지 않고 재사용
	*/
		
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		if(!status.isComplete()) {		//세션이 아직 살아있는 상태면
			status.setComplete();
		}
		
		return "redirect:/";
	}
	
	
		
}

 