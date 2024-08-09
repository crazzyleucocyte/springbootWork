package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.doain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam("username") String username, Model model) {
		Member member =Member.builder()
							 .username(username)
							 .createDate(LocalDate.now())
							 .build();
		Member result = memberService.insert(member);
		model.addAttribute("member",result);
		return "insert";
	}
	
	@RequestMapping("/select")
	public String select(@RequestParam("id")Long id, Model model) {
		Optional<Member> member = memberService.select(id);
		// member.isPresent()는 member객체 안에 데이터가 있는지 없는지 체크하는것
		// optional을 벗겨서 Member로 내보내려면 member.get()을 하면 된다.
		if(member.isPresent()) {
			model.addAttribute("member", member.get());	// member.get() : Optional의 wrapping을 풀어서 Member만 가져오기
		} else {
			model.addAttribute("member",null);
		}
		return"select";
	}
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> alist = memberService.selectAll();
		model.addAttribute("mList", alist);
		return "selectAll";
	}
	
	@RequestMapping("/update")
	public String update(Member member, Model m) {
		member.setCreateDate(LocalDate.now());
		Member rMember = memberService.update(member);
		m.addAttribute("rMember", rMember);
		return "update";
	}
	
	@RequestMapping("/delete")
	public String delete(Long id, Model model) {
		System.out.println("id : "+id);
		memberService.delete(id);
		return "menu";

	}
	
	
	
	
	
	
}
