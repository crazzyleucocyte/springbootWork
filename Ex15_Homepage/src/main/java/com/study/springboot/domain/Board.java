package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@Entity(name="board2")
@EntityListeners(AuditingEntityListener.class)
public class Board {

	@Id
	@SequenceGenerator(
			name="boardseq",
			sequenceName="board2_seq",
			allocationSize=1
			)
	@GeneratedValue(generator="boardseq")
	private Long bno;

	@NonNull
	private String title;
	
	@NonNull
	private String content;
	
	@NonNull
	private String writer;
	
	@Column(insertable=false, columnDefinition="NUMBER DEFAULT 0")
	private Long count;
	
	@CreatedDate
	@Column(name="create_date", insertable=false, nullable=false, columnDefinition="DATE DEFAULT SYSDATE")   
	//insertable=false insert할때 넣지 마시오라는 뜻 그리고 그 뒤에 디폴트 값을 정해주었다.
	//updatable=false도 update할때 넣지 마시오라는 뜻
	//columnDefinition="DATE DEFAULT SYSDATE"는디폴트 값을 정해주었다.
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;

}
