package com.study.springboot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	
	@RequestMapping("/selectByNameLike")
	public String selectByNameLike(String name, int page, Model model) {
		String search= name+"%";
		
		/*
			Pageable 인터페이스
			: Spring에서 Pagination을 지원하는 Pageable인터페이스 제공
			- getPageNumber() : 현재 페이지 번호를 반환(0부터 시작)
			- getPageSize() : 한 페이지당 항목 수를 반환
			- getOffset() : 현재 페이지의 시작 위치를 반환
			- getSort() : 정렬 정보를 반환
			- next() : 다음페이지 정보를 반환
			- previous() : 이전페이지 정보를 반환
			
		   * PageRequest 클래스
		     : Spring Data JPA에서 제공하는 Pageable 구현체 중 하나로 페이지 정보를 생성하는 클래스
		     - page : 조회할 페이지 번호(0부터 시작)
		     - size : 한 페이지당 항목수
		     - sort : 정렬 정보(생략가능)
		     - direction : 정렬 방향(ASC, DESC)
		     - properties : 정렬 대상 속성명
		     
		   > 생성자
		   	 PageRequest(int page, int size)
		   	 PageRequest(int page, int size, Sort sort)
		   	 PageRequest(int page, int size, Sort.Direction direction, String... properties)
			
		*/
		
		Sort sort = Sort.by(Sort.Order.desc("name"));
		Pageable pr = PageRequest.of(page-1, 10, sort);
//		Pageable pr = PageRequest.of(page-1, 10, Sort.by("name").ascending());
//		Pageable pr = PageRequest.of(page-1, 10, Sort.by("name").descending());
		/*Pageable pr = PageRequest.ofSize(10)
								 .withPage(page-1)
								 .withSort(sort);*/
		
		Page<Member> result=memberService.selectByNameLike(search, pr);
		List<Member> content = result.getContent();				//실제 객체가 담긴 List<Member>가 반환됨
		Long totalRecord = result.getTotalElements();			//총 레코드 수
		int totalPage = result.getTotalPages();					//총 페이지수
		int size = result.getSize();							//페이지당 레코드 수
		int nowPage = result.getNumber();						//현재 페이지(0부터 시작)
		int numberOfElements = result.getNumberOfElements();	//현재 페이지의 항목 
		
		model.addAttribute("members", content);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("size", size);
		model.addAttribute("totalPages", totalPage);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("numberOfElements", numberOfElements);
		return "selectList";
	}
	
	
	
	
}
