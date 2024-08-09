package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//아래 어노테이션은 @createDate와 @LastModifiedDate를 사용할 떄 반드시 추가해야함
//그리고 main에 Ex10AssociativeMappingApplication에다가 @EnableJpaAuditing를 반드시 넣어줘야함
@EntityListeners(AuditingEntityListener.class)	// 이거를 넣어줘야 얘가 자동으로 시간을 넣어야한다는것을 알게됨
@Entity(name="member03")
public class Member {
	
	@Id
	private String id;
	
	private String name;
	private String password;
	
	//엔티티의 생성될 때 날짜와 시간 저장
	@CreatedDate
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@LastModifiedDate	//엔티티가 수정될 때 날짜와 시간 저장
	@Column(name="update_at")
	private LocalDateTime updateAt;
}
