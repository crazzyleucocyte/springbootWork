package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MenuController {

	@GetMapping("/menuForm")
	public String menuForm() {
		return"menu/menuForm";
	}
	
	
}
