package com.study.springboot.domain;

import java.time.LocalDate;
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
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Reply {
	
	@Id
	@SequenceGenerator(
			name="replyseq",
			sequenceName="reply2_seq",
			allocationSize=1
			)
	@GeneratedValue(generator="replyseq")
	private Long rno;
	
	@NonNull
	private String content;
	
	@NonNull
	private String writer;
	
	@NonNull
	@Column(name="ref_bno")
	private Long refBno;
	
	@CreatedDate
	@Column(name="create_date", insertable=false, updatable=false, columnDefinition="DATE DEFAULT SYSDATE")
	private LocalDate createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;

	public Reply(@NonNull String content, @NonNull String writer, @NonNull Long refBno) {
		super();
		this.content = content;
		this.writer = writer;
		this.refBno = refBno;
	}

	public Reply(@NonNull String content) {
		super();
		this.content = content;
	}
	
	
	
	
	
}
