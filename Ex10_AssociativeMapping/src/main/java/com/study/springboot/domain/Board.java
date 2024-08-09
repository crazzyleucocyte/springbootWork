package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
	
	@ManyToOne			//다 대 일의 관계
	@JoinColumn(name="writer")		//board테이블에 writer컬럼을 추가하고 외래키로 지정
	private Member member;
}
