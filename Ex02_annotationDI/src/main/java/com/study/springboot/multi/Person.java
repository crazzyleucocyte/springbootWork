package com.study.springboot.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//이름을 명시하지 않으면 빈의 이름은 소문자로 등록(person등록)
@Component
public class Person {
	
	//이렇게 하면 name에 자동으로 홍길동이 들어간다.
	@Value("홍길동")
	private String name;
	
	@Value("동에번쩍 서에 번쩍")
	private String nickname;
	
	//autowired만 쓰면 printer에 있는 두 개중에 어떤걸 인식할지 모르기 떄문에 지정해줘야 한다
	@Autowired
	@Qualifier("printera")	//printerA에 @conponent로 이름을 printera로 입력해서 여기 qualifier에도 printera라고 해야한다.
	private Printer printer;
	public Person() {
		super();
	}
	public Person(String name, String nickname, Printer printer) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.printer = printer;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public void print() {
		printer.print("Hello " + name + " : " + nickname );
	}
	
	
}
