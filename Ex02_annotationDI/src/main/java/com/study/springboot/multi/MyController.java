package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @controller : bean으로 등록하시오

/*
	어떤 기능을 수행하는 경우는 @Controller
	의존성 주입에 사용되는 경우는 @Component 
*/
@Controller
public class MyController {
	//Person Person= new Person(); 을 간단하게 @autowired 해주면 얘가 알아서 관리 해준다.
	@Autowired
	Person Person1;
	
	@Autowired
	@Qualifier("printerB")
	Printer printer;

	@Autowired
	Person Person2;
	
	//get으로 하든post로 하든 다 여기로 들어온다
	@RequestMapping("/")
	//public @ResponseBody String root() {  에서 @ResponseBody의 의미는 여기로 보내겠다는 뜻 
	public @ResponseBody String root() {
		return "Annotation DI 사용하기";
	}
	
}
