package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Menu;
import com.study.springboot.service.MenuService;

@RestController
@RequestMapping("/menu")		//뭐가 됐든 /menu가 붙어있는거는 모두 이 컨트롤러로 들어오도록 했다.
public class MenuRestController {

	@Autowired
	MenuService menuService;
	
	@GetMapping
	public List<Menu> menuAllList(){
		return menuService.menuAllList();
	}
	
	
	
}
