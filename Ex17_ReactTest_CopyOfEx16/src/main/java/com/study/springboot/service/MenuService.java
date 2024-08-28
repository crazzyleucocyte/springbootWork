package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;

	public List<Menu> menuAllList() {
		return menuRepository.findAll();
	}


	public List<Menu> findByType(Type type) {
		return menuRepository.findByType(type);
	}


	public List<Menu> findByTypeAndTaste(Type type, Taste taste) {
		return menuRepository.findByTypeAndTaste(type, taste);
	}


	public Optional<Menu> findById(Long id) {
		return menuRepository.findById(id);
	}


	public Menu insertMenu(Menu menu) {
		return menuRepository.save(menu);
	}


	public Menu updateMenu(Menu menu) {
		
		//원래 update를 하려면 영속성에 해당 id로 조회한 menu 객체가 존재해야 가능한데 
		//아래에 findById를 주석처리해도 update가 되는 이유는 메뉴 수정하기에서 이미 메뉴번호로 한번 조회해서 영속성에 이미 들어있어서 가능한것
		/*Menu reMenu = menuRepository.findById(menu.getId()).get();*/
		return menuRepository.save(menu);
	}


	public void deleteMenu(Long id) {
		menuRepository.deleteById(id);
	}
}
