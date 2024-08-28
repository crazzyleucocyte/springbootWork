package com.study.springboot.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)		//날짜 및 시간 자동 기록 리스너
public class Member {
	@Id
	private String id;
	@NonNull
	private String password;
	@NonNull
	private String name;
	private String email;
	private LocalDate birthday;
	private String gender;
	private String phone;
	private String address;
	
	@CreatedDate
	@Column(name="create_date", insertable=false, updatable=false, columnDefinition="DATE DEFAULT SYSDATE")   
	//insertable=false insert할때 넣지 마시오라는 뜻 그리고 그 뒤에 디폴트 값을 정해주었다.
	//updatable=false도 update할때 넣지 마시오라는 뜻
	//columnDefinition="DATE DEFAULT SYSDATE"는디폴트 값을 정해주었다.
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;
	
	
	
}
