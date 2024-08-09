package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	@RequestMapping("/selectAll")
	public String selectAll(Model m) {
		List <Member> list =memberService.selectAll();
		m.addAttribute("list", list);
		m.addAttribute("title","All");
		return "selectAll";
	}
	
	@RequestMapping("/selectById")
	public String selectById(Long id, Model model) {
		 Optional <Member> m = memberService.select(id);
		 if(m.isPresent()) {
			 model.addAttribute("member", m.get());
			 model.addAttribute("title","Id");
			 
		 }else {
			 model.addAttribute("member", null);
		 }
		 return "selectByOne";
	}
	
	@RequestMapping("/selectByName")
	public String selectByName(String name, Model model) {
		Optional<Member> member = memberService.selectByName(name);
		model.addAttribute("member",member.get());
		model.addAttribute("title","Name");
		
		return "selectByOne";
	}
	
	@RequestMapping("/selectByEmail")
	public String selectBYEmail(String email, Model model) {
		Optional<Member> member=memberService.selectByEmail(email);
		model.addAttribute("member",member.get());
		model.addAttribute("title","Email");
		return "selectByOne";
	}

	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(String name, Model model) {
		String username= name+"%";
		List<Member> list=memberService.selectByNameLike(username);
		model.addAttribute("list",list);
		model.addAttribute("title","NameLike");
		return "selectAll";
	}
	@RequestMapping("/selectByNameLikeDesc")
	public String selectByNameLikeDesc(String name, Model model) {
		String username= name+"%";
		List<Member> list=memberService.selectByNameLikeDesc(username);
		model.addAttribute("list",list);
		model.addAttribute("title","NameLikeDesc");
		return "selectAll";
	}
	@RequestMapping("/selectByNameLikeSort")
	public String selectByNameLikeSort(String name, Model model) {
		String username= name+"%";
		Sort sort= Sort.by(Sort.Order.desc("username"), Sort.Order.asc("email"));
		
		List<Member> list=memberService.selectByNameLikeDesc(username,sort);
		model.addAttribute("list",list);
		model.addAttribute("title","NameLikeDesc");
		return "selectAll";
	}
	
	
	
}
