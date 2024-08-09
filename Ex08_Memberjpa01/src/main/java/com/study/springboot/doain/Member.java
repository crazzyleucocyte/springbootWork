package com.study.springboot.doain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="member01")	//이 클래스는 member01이라는 테이블과 매핑시키겠다는 뜻
public class Member {
	@Id								//primary key로 지정하겠다는 뜻
	@GeneratedValue					//시퀀스를 만들겠다는 뜻, 시퀀스이름은 테이블명_seq
	private Long id;
	private String username;
	@Column(name="create_date")		//이 변수는 member01의 create_date랑 매핑하겠다는 뜻
	private LocalDate createDate;
	
	
}
