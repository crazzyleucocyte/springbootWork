package com.study.springboot.doain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="member02")	//이 클래스는 member01이라는 테이블과 매핑시키겠다는 뜻
public class Member {
	@Id								//primary key로 지정하겠다는 뜻
	@GeneratedValue					//시퀀스를 만들겠다는 뜻, 시퀀스이름은 테이블명_seq
	private Long id;
	private String username;
	private String email;
	
	public Member(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}
	
	
}
