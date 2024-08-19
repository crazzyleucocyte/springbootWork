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
	@JoinColumn(name="writer")		
	// board테이블에 writer컬럼을 추가하고 외래키로 지정
	// 다른 테이블에 있는 컬럼 중 이 테이블에 넣어야하는 값이 두 개 이상인 경우 쓰는것이 효율적인듯
	private Member member;
}
