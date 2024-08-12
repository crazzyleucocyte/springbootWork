package com.study.springboot.doain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Entity(name="JPAPAGING")	
public class Member {
	@Id								//primary key로 지정하겠다는 뜻
	@SequenceGenerator(
			name="PAGINGSEQ",
			sequenceName="JPAPAGING_SEQ",
			initialValue=1,
			allocationSize=1
			)
	@GeneratedValue(generator="PAGINGSEQ")					//시퀀스를 만들겠다는 뜻, 시퀀스이름은 테이블명_seq
	private Long id;
	private String name;
	private String email;
	
	
	
	
}
